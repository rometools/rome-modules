/*
 * ITunes.java
 *
 * Created on November 19, 2005, 10:58 PM
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
 */

package org.rometools.feed.module.itunes;

import java.net.URL;

import com.sun.syndication.feed.module.Module;

/**
 * This interface contains the methods common to all iTunes module points.
 * 
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 * @version $Revision: 1.3 $
 */
public interface ITunes extends Module {
    /**
     * Marker for podcasts containing explicit material.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#explicit
     */
    enum Explicit {
        yes, no, clean
    }

    /**
     * Namespace-URL.
     */
    String URI = AbstractITunesObject.URI;

    /**
     * Returns the author string for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#authorId
     * @return Returns the author string for this feed or entry
     */
    String getAuthor();

    /**
     * Sets the author string for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#authorId
     * @param author Sets the author string for this feed or entry
     */
    void setAuthor(String author);

    /**
     * Boolean as to whether to block this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#block
     * @return Boolean as to whether to block this feed or entry
     */
    boolean getBlock();

    /**
     * Boolean as to whether to block this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#block
     * @param block Boolean as to whether to block this feed or entry
     */
    void setBlock(boolean block);

    /**
     * whether this feed or entry contains adult content or not.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#explicit
     * @return explicit state as to whether this feed or entry contains adult content
     */
    Explicit getExplicit();

    /**
     * whether this feed or entry contains adult content or not.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#explicit
     * @param explicit explicit state as to whether this feed or entry contains adult content
     */
    void setExplicit(Explicit explicit);

    /**
     * Sets the URL for the image.
     * 
     * NOTE: To specification images should be in PNG or JPEG format.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#image
     * @param image Sets the URL for the image.
     */
    void setImage(URL image);

    /**
     * Returns the URL for the image.
     * 
     * NOTE: To specification images should be in PNG or JPEG format.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#image
     * @return Returns the URL for the image.
     */
    URL getImage();

    /**
     * A list of keywords for this feed or entry.
     * 
     * Must not contain spaces
     * 
     * NOTE: Not referenced on http://www.apple.com/itunes/podcasts/specs.html!
     * 
     * @return A list of keywords for this feed or entry
     * @deprecated
     */
    String[] getKeywords();

    /**
     * A list of keywords for this feed or entry.
     * 
     * Must not contain spaces
     * 
     * NOTE: Not referenced on http://www.apple.com/itunes/podcasts/specs.html!
     * 
     * @param keywords A list of keywords for this feed or entry
     * @deprecated
     */
    void setKeywords(String[] keywords);

    /**
     * A subtitle for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#subtitle
     * @return A subtitle for this feed or entry
     */
    String getSubtitle();

    /**
     * A subtitle for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#subtitle
     * @param subtitle A subtitle for this feed or entry
     */
    void setSubtitle(String subtitle);

    /**
     * A subtitle for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#summary
     * @return A subtitle for this feed or entry
     */
    String getSummary();

    /**
     * A subtitle for this feed or entry.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#summary
     * @param summary A subtitle for this feed or entry
     */
    void setSummary(String summary);

}
