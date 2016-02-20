/*
 * ITunesParserTest.java
 * JUnit based test
 *
 * Created on August 2, 2005, 1:30 PM
 */
package com.rometools.modules.itunes;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rometools.modules.AbstractTestCase;
import com.rometools.modules.itunes.EntryInformation.ClosedCaptioned;
import com.rometools.modules.itunes.ITunes.Explicit;
import com.rometools.modules.itunes.io.ITunesGenerator;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author cooper
 */
public class ITunesParserTest extends AbstractTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(ITunesParserTest.class);
    private static final int itemCountInLeShowFeed = 4;

    public ITunesParserTest(final String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(ITunesParserTest.class);

        return suite;
    }

    /**
     * Test of getNamespaceUri method, of class com.totsp.xml.syndication.itunes.ITunesParser.
     */
    public void testGetNamespaceUri() {
        LOG.debug("testGetNamespaceUri");

        assertEquals("Namespace", "http://www.itunes.com/dtds/podcast-1.0.dtd", new ITunesGenerator().getNamespaceUri());
    }

    /**
     * Test of parse method, of class com.totsp.xml.syndication.itunes.ITunesParser.
     */
    public void testParse() throws Exception {
        File feed = new File(getTestFile("xml/leshow.xml"));
        final SyndFeedInput input = new SyndFeedInput();
        SyndFeed syndfeed = input.build(new XmlReader(feed.toURI().toURL()));

        final Module module = syndfeed.getModule(AbstractITunesObject.URI);
        final FeedInformationImpl feedInfo = (FeedInformationImpl) module;

        assertEquals("owner", "Harry Shearer", feedInfo.getOwnerName());
        assertEquals("email", "", feedInfo.getOwnerEmailAddress());
        assertEquals("image", "http://a1.phobos.apple.com/Music/y2005/m06/d26/h21/mcdrrifv.jpg", feedInfo.getImage().toExternalForm());
        assertEquals("category", "Comedy", feedInfo.getCategories().get(0).getName());
        assertEquals(
                "summary",
                "A weekly, hour-long romp through the worlds of media, politics, sports and show business, leavened with an eclectic mix of mysterious music, hosted by Harry Shearer.",
                feedInfo.getSummary());
        assertEquals("complete", Boolean.TRUE, feedInfo.getComplete());
        assertEquals("new-feed-url", "http://newlocation.com/example.rss", feedInfo.getNewFeedUrl().toExternalForm());
        assertFalse("block", feedInfo.getBlock());        

        List<SyndEntry> entries = syndfeed.getEntries();
        Iterator<SyndEntry> it = entries.iterator();

        while (it.hasNext()) {
            final SyndEntry entry = it.next();
            final EntryInformationImpl entryInfo = (EntryInformationImpl) entry.getModule(AbstractITunesObject.URI);
            LOG.debug("{}", entryInfo);
        }

        feed = new File(getTestFile("xml/rsr.xml"));
        syndfeed = input.build(new XmlReader(feed.toURI().toURL()));
        entries = syndfeed.getEntries();
        it = entries.iterator();

        while (it.hasNext()) {
            final SyndEntry entry = it.next();
            final EntryInformationImpl entryInfo = (EntryInformationImpl) entry.getModule(AbstractITunesObject.URI);
            LOG.debug("{}", entryInfo.getDuration());
        }

    }

    /**
     * Test of parse method, of class com.rometools.modules.itunes.io.ITunesParser.
     */
    public void testParseItem() throws Exception {
        File feed = new File(getTestFile("xml/leshow.xml"));
        final SyndFeedInput input = new SyndFeedInput();
        SyndFeed syndfeed = input.build(new XmlReader(feed.toURI().toURL()));

        SyndEntry entry = syndfeed.getEntries().get(0);

        EntryInformationImpl entryInfo = (EntryInformationImpl) entry.getModule(AbstractITunesObject.URI);
        assertEquals(true, entryInfo.getClosedCaptioned());
        assertEquals(Integer.valueOf(2), entryInfo.getOrder());
        assertEquals("http://example.org/image.png", entryInfo.getImage().toString());
    }

    /**
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testParseRsr() throws IOException, FeedException {
        final SyndFeed syndfeed = getSyndFeed("xml/rsr.xml");
        final List<SyndEntry> entries = syndfeed.getEntries();
        final Iterator<SyndEntry> it = entries.iterator();
        while (it.hasNext()) {
            final SyndEntry entry = it.next();
            final EntryInformationImpl entryInfo = (EntryInformationImpl) entry.getModule(AbstractITunesObject.URI);
            LOG.debug("{}", entryInfo.getDuration());
        }
    }

    /**
     * test for itunes:explicit tags.
     * 
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testImageTagOnItem() throws IOException, FeedException {
        final SyndFeed feed = getSyndFeed("xml/leshow.xml");
        assertEquals("http://a1.phobos.apple.com/Music/y2005/m06/d26/h21/mcdrrifv.jpg",
                ((EntryInformation) feed.getEntries().get(0).getModule(AbstractITunesObject.URI)).getImage().toExternalForm());
    }

    /**
     * test for itunes:explicit tags.
     * 
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testExplicitTags() throws IOException, FeedException {
        final SyndFeed feed = getSyndFeed("xml/leshow.xml");
        final FeedInformationImpl feedInfo = (FeedInformationImpl) feed.getModule(AbstractITunesObject.URI);
        assertEquals("explicit tag on feed", Explicit.no, feedInfo.getExplicit());
        assertEquals("wrong count of items", itemCountInLeShowFeed, feed.getEntries().size());
        assertEquals("explicit tag on 1. item", Explicit.yes,
                ((EntryInformation) feed.getEntries().get(0).getModule(AbstractITunesObject.URI)).getExplicit());
        assertEquals("explicit tag on 2. item", Explicit.no,
                ((EntryInformation) feed.getEntries().get(1).getModule(AbstractITunesObject.URI)).getExplicit());
        assertEquals("explicit tag on 3. item", Explicit.clean,
                ((EntryInformation) feed.getEntries().get(2).getModule(AbstractITunesObject.URI)).getExplicit());
        assertNull("explicit tag on 4. item",
                ((EntryInformation) feed.getEntries().get(3).getModule(AbstractITunesObject.URI)).getExplicit());
    }

    /**
     * test for itunes:isClosedCaptioned tags.
     * 
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testClosedCaptionedTags() throws IOException, FeedException {
        final SyndFeed feed = getSyndFeed("xml/leshow.xml");
        assertEquals("wrong count of items", itemCountInLeShowFeed, feed.getEntries().size());
        assertEquals("isClosedCaptioned tag on 1. item", ClosedCaptioned.yes,
                ((EntryInformation) feed.getEntries().get(0).getModule(AbstractITunesObject.URI)).getClosedCaptioned());
        assertEquals("isClosedCaptioned tag on 2. item", ClosedCaptioned.no,
                ((EntryInformation) feed.getEntries().get(1).getModule(AbstractITunesObject.URI)).getClosedCaptioned());
        assertEquals("isClosedCaptioned tag on 3. item", ClosedCaptioned.no,
                ((EntryInformation) feed.getEntries().get(2).getModule(AbstractITunesObject.URI)).getClosedCaptioned());
        assertNull("isClosedCaptioned tag on 4. item",
                ((EntryInformation) feed.getEntries().get(3).getModule(AbstractITunesObject.URI)).getClosedCaptioned());
    }

    /**
     * test for itunes:order tags.
     * 
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testOrderTags() throws IOException, FeedException {
        final SyndFeed feed = getSyndFeed("xml/leshow.xml");
        assertEquals("wrong count of items", itemCountInLeShowFeed, feed.getEntries().size());
        assertEquals("order tag on 1. item", Integer.valueOf(2),
                ((EntryInformation) feed.getEntries().get(0).getModule(AbstractITunesObject.URI)).getOrder());
        assertEquals("order tag on 2. item", Integer.valueOf(1),
                ((EntryInformation) feed.getEntries().get(1).getModule(AbstractITunesObject.URI)).getOrder());
        assertNull("order tag on 3. item",
                ((EntryInformation) feed.getEntries().get(2).getModule(AbstractITunesObject.URI)).getOrder());
        assertNull("order tag on 4. item",
                ((EntryInformation) feed.getEntries().get(3).getModule(AbstractITunesObject.URI)).getOrder());
    }

    /**
     * test for itunes:block tags.
     * 
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    public void testBlockTags() throws IOException, FeedException {
        final SyndFeed feed = getSyndFeed("xml/leshow.xml");
        assertEquals("wrong count of items", itemCountInLeShowFeed, feed.getEntries().size());
        assertTrue("block tag on 1. item",
                ((EntryInformation) feed.getEntries().get(0).getModule(AbstractITunesObject.URI)).getBlock());
        assertFalse("block tag on 2. item",
                ((EntryInformation) feed.getEntries().get(1).getModule(AbstractITunesObject.URI)).getBlock());
        assertFalse("block tag on 3. item",
                ((EntryInformation) feed.getEntries().get(2).getModule(AbstractITunesObject.URI)).getBlock());
        assertFalse("block tag on 4. item",
                ((EntryInformation) feed.getEntries().get(3).getModule(AbstractITunesObject.URI)).getBlock());
    }

    /**
     * @param testfile path to test file
     * @return SyndFeed from test file
     * @throws FeedException if error on parsing feed
     * @throws IOException if file not readable
     */
    private SyndFeed getSyndFeed(final String testfile) throws IOException, FeedException {
        return new SyndFeedInput().build(new File(getTestFile(testfile)));
    }
}
