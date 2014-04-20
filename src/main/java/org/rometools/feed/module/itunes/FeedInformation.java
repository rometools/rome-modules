/*
 * FeedInformation.java
 *
 * Created on November 19, 2005, 10:57 PM
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
package org.rometools.feed.module.itunes;

import java.net.URL;
import java.util.List;

import org.rometools.feed.module.itunes.types.Category;

/**
 * This class contains information for iTunes podcast feeds that exist at the Channel level.
 * 
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 * @version $Revision: 1.2 $
 */
public interface FeedInformation extends ITunes {

    /**
     * The parent categories for this feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#category
     * @return The parent categories for this feed
     */
    List<Category> getCategories();

    /**
     * The parent categories for this feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#category
     * @param categories The parent categories for this feed
     */
    void setCategories(List<Category> categories);

    /**
     * indicate the completion of a podcast.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#complete
     * @return {@code true} if no more episodes will be added to the podcast
     */
    Boolean getComplete();

    /**
     * For changing the feed url.
     * 
     * NOTE: the old feed URL should be maintained for 48 hours.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#newfeed
     * @return URL of new feed location
     */
    URL getNewFeedUrl();

    /**
     * For changing the feed url.
     * 
     * NOTE: the old feed URL should be maintained for 48 hours.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#newfeed
     * @param newFeedUrl URL of new feed location
     */
    void setNewFeedUrl(URL newFeedUrl);

    /**
     * indicate the completion of a podcast.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#complete
     * @param complete {@code true} if no more episodes will be added to the podcast
     */
    void setComplete(Boolean complete);

    /**
     * Sets the owner email address for the feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#owner
     * @param ownerEmailAddress Sets the owner email address for the feed.
     */
    void setOwnerEmailAddress(String ownerEmailAddress);

    /**
     * Returns the owner email address for the feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#owner
     * @return Returns the owner email address for the feed.
     */
    String getOwnerEmailAddress();

    /**
     * Sets the owner name for the feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#owner
     * @param ownerName Sets the owner name for the feed
     */
    void setOwnerName(String ownerName);

    /**
     * Returns the owner name for the feed.
     * 
     * @see http://www.apple.com/itunes/podcasts/specs.html#owner
     * @return Returns the owner name for the feed
     */
    String getOwnerName();
}
