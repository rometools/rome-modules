/*
 * AbstractITunesObject.java
 *
 * Created on August 1, 2005, 7:37 PM
 *
 * This library is provided under dual licenses.
 * You may choose the terms of the Lesser General Public License or the Apache
 * License at your discretion.
 *
 *  Copyright (C) 2005  Robert Cooper, Temple of the Screaming Penguin
 *
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.rometools.modules.itunes;

import java.net.URL;
import java.util.Arrays;

/**
 * This is an abstract object that implements the attributes common across Feeds or Items in an
 * iTunes compatible RSS feed.
 *
 * @version $Revision: 1.4 $
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 */
public abstract class AbstractITunesObject implements ITunes, java.lang.Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The URI that iTunes used for its custom tags.
     * <p>
     * What is up with using a versioned DTD anyway?
     * </p>
     * \
     */
    public static final String URI = "http://www.itunes.com/dtds/podcast-1.0.dtd";

    /**
     * The RDF namespace URI.
     */
    public static final String RDF_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";

    /**
     * A default prefix to use for itunes tags.
     */
    public static final String PREFIX = "itunes";
    private String author;
    private boolean block;
    private Explicit explicit;
    private String[] keywords = new String[0];
    private String subtitle;
    private String summary;
    private URL image;

    /**
     * Defined by the ROME API.
     * 
     * @return Class of the Interface for this module.
     */
    @Override
    public Class<? extends AbstractITunesObject> getInterface() {
        return getClass();
    }

    /**
     * The URI this module implements.
     * 
     * @return "http://www.itunes.com/dtds/podcast-1.0.dtd"
     */
    @Override
    public String getUri() {
        return AbstractITunesObject.URI;
    }

    /**
     * Required by the ROME API.
     * 
     * @return A clone of this module object
     */
    @Override
    public abstract Object clone();

    /**
     * Returns the author string for this feed or entry.
     * 
     * @return Returns the author string for this feed or entry
     */
    @Override
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author string for this feed or entry.
     * 
     * @param author Sets the author string for this feed or entry
     */
    @Override
    public void setAuthor(final String author) {
        this.author = author;
    }

    /**
     * Boolean as to whether to block this feed or entry.
     * 
     * @return Boolean as to whether to block this feed or entry
     */
    @Override
    public boolean getBlock() {
        return block;
    }

    /**
     * Boolean as to whether to block this feed or entry.
     * 
     * @param block Boolean as to whether to block this feed or entry
     */
    @Override
    public void setBlock(final boolean block) {
        this.block = block;
    }

    /**
     * Boolean as to whether this feed or entry contains adult content.
     * 
     * @return Boolean as to whether this feed or entry contains adult content
     */
    @Override
    public Explicit getExplicit() {
        return explicit;
    }

    /**
     * Boolean as to whether this feed or entry contains adult content.
     * 
     * @param explicit Boolean as to whether this feed or entry contains adult content
     */
    @Override
    public void setExplicit(final Explicit explicit) {
        this.explicit = explicit;
    }

    /**
     * Returns the URL for the image.
     * 
     * NOTE: To specification images should be in PNG or JPEG format.
     * 
     * @return Returns the URL for the image.
     */
    @Override
    public URL getImage() {
        return image;
    }

    /**
     * Sets the URL for the image.
     * 
     * NOTE: To specification images should be in PNG or JPEG format.
     * 
     * @param image Sets the URL for the image.
     */
    @Override
    public void setImage(final URL image) {
        this.image = image;
    }

    /**
     * A list of keywords for this feed or entry.
     * 
     * Must not contain spaces
     * 
     * @return A list of keywords for this feed or entry
     */
    @Override
    public String[] getKeywords() {
        return keywords;
    }

    /**
     * A list of keywords for this feed or entry.
     * 
     * Must not contain spaces
     * 
     * @param keywords A list of keywords for this feed or enty
     */
    @Override
    public void setKeywords(final String[] keywords) {
        if (keywords == null) {
            this.keywords = new String[0];
        } else {
            this.keywords = keywords;
        }
    }

    /**
     * A subtitle for this feed or entry.
     * 
     * @return A subtitle for this feed or entry
     */
    @Override
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * A subtitle for this feed or entry.
     * 
     * @param subtitle A subtitle for this feed or entry
     */
    @Override
    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * A subtitle for this feed or entry.
     * 
     * @return A subtitle for this feed or entry
     */
    @Override
    public String getSummary() {
        return summary;
    }

    /**
     * A subtitle for this feed or entry.
     * 
     * @param summary A subtitle for this feed or entry
     */
    @Override
    public void setSummary(final String summary) {
        this.summary = summary;
    }

    //CHECKSTYLE:OFF
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (author == null ? 0 : author.hashCode());
        result = prime * result + (block ? 1231 : 1237);
        result = prime * result + (explicit == null ? 0 : explicit.hashCode());
        result = prime * result + (image == null ? 0 : image.hashCode());
        result = prime * result + Arrays.hashCode(keywords);
        result = prime * result + (subtitle == null ? 0 : subtitle.hashCode());
        result = prime * result + (summary == null ? 0 : summary.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractITunesObject other = (AbstractITunesObject) obj;
        if (author == null) {
            if (other.author != null) {
                return false;
            }
        } else if (!author.equals(other.author)) {
            return false;
        }
        if (block != other.block) {
            return false;
        }
        if (explicit != other.explicit) {
            return false;
        }
        if (image == null) {
            if (other.image != null) {
                return false;
            }
        } else if (!image.equals(other.image)) {
            return false;
        }
        if (!Arrays.equals(keywords, other.keywords)) {
            return false;
        }
        if (subtitle == null) {
            if (other.subtitle != null) {
                return false;
            }
        } else if (!subtitle.equals(other.subtitle)) {
            return false;
        }
        if (summary == null) {
            if (other.summary != null) {
                return false;
            }
        } else if (!summary.equals(other.summary)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ", author=" + author + ", block=" + block + ", explicit=" + explicit + ", keywords=" + Arrays.toString(keywords)
                + ", subtitle=" + subtitle + ", summary=" + summary + ", image=" + image;
    }
    //CHECKSTYLE:ON

}

