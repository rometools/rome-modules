/*
 * FeedInformation.java
 *
 * Created on August 1, 2005, 7:11 PM
 *
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
import java.util.ArrayList;
import java.util.List;

import org.rometools.feed.module.itunes.types.Category;

import com.sun.syndication.feed.CopyFrom;

/**
 * This class contains information for iTunes podcast feeds that exist at the Channel level.
 * 
 * @version $Revision: 1.2 $
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 */
public class FeedInformationImpl extends AbstractITunesObject implements FeedInformation {
    private static final long serialVersionUID = -8291798441032794096L;
    private String ownerName;
    private String ownerEmailAddress;
    private List<Category> categories;
    private URL newFeedUrl;
    private Boolean complete;

    /**
     * Creates a new instance of FeedInformationImpl.
     */
    public FeedInformationImpl() {
    }

    /**
     * The parent categories for this feed.
     * 
     * @return The parent categories for this feed
     */
    @Override
    public List<Category> getCategories() {
        if (categories == null) {
            categories = new ArrayList<Category>();
        }
        return categories;
    }

    /**
     * The parent categories for this feed.
     * 
     * @param categories The parent categories for this feed
     */
    @Override
    public void setCategories(final List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

    @Override
    public void setComplete(final Boolean complete) {
        this.complete = complete;
    }

    @Override
    public URL getNewFeedUrl() {
        return newFeedUrl;
    }

    @Override
    public void setNewFeedUrl(final URL newFeedUrl) {
        this.newFeedUrl = newFeedUrl;
    }

    /**
     * Returns the owner name for the feed.
     * 
     * @return Returns the owner name for the feed
     */
    @Override
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the owner name for the feed.
     * 
     * @param ownerName Sets the owner name for the feed
     */
    @Override
    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Returns the owner email address for the feed.
     * 
     * @return Returns the owner email address for the feed.
     */
    @Override
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    /**
     * Sets the owner email address for the feed.
     * 
     * @param ownerEmailAddress Sets the owner email address for the feed.
     */
    @Override
    public void setOwnerEmailAddress(final String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }

    /**
     * Required by the ROME API.
     * 
     * @param obj object to copy property values from
     */
    @Override
    public void copyFrom(final CopyFrom obj) {
        final FeedInformationImpl info = (FeedInformationImpl) obj;
        setAuthor(info.getAuthor());
        setBlock(info.getBlock());
        getCategories().clear();
        if (info.getCategories() != null) {
            getCategories().addAll(info.getCategories());
        }
        setComplete(info.getComplete());
        setExplicit(info.getExplicit());
        setImage(info.getImage());
        if (info.getKeywords() != null) {
            setKeywords(info.getKeywords().clone());
        }
        setNewFeedUrl(info.getNewFeedUrl());
        setOwnerEmailAddress(info.getOwnerEmailAddress());
        setOwnerName(info.getOwnerName());
        setSubtitle(info.getSubtitle());
        setSummary(info.getSummary());
    }

    /**
     * Returns a copy of this FeedInformationImpl object.
     * 
     * @return Returns a copy of this FeedInformationImpl object
     */
    @Override
    public Object clone() {
        final FeedInformationImpl info = new FeedInformationImpl();
        info.copyFrom(this);

        return info;
    }

    //CHECKSTYLE:OFF
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((categories == null) ? 0 : categories.hashCode());
        result = prime * result + ((complete == null) ? 0 : complete.hashCode());
        result = prime * result + ((newFeedUrl == null) ? 0 : newFeedUrl.hashCode());
        result = prime * result + ((ownerEmailAddress == null) ? 0 : ownerEmailAddress.hashCode());
        result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FeedInformationImpl other = (FeedInformationImpl) obj;
        if (categories == null) {
            if (other.categories != null) {
                return false;
            }
        } else if (!categories.equals(other.categories)) {
            return false;
        }
        if (complete == null) {
            if (other.complete != null) {
                return false;
            }
        } else if (!complete.equals(other.complete)) {
            return false;
        }
        if (newFeedUrl == null) {
            if (other.newFeedUrl != null) {
                return false;
            }
        } else if (!newFeedUrl.equals(other.newFeedUrl)) {
            return false;
        }
        if (ownerEmailAddress == null) {
            if (other.ownerEmailAddress != null) {
                return false;
            }
        } else if (!ownerEmailAddress.equals(other.ownerEmailAddress)) {
            return false;
        }
        if (ownerName == null) {
            if (other.ownerName != null) {
                return false;
            }
        } else if (!ownerName.equals(other.ownerName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FeedInformationImpl [ownerName=" + ownerName + ", ownerEmailAddress=" + ownerEmailAddress + ", categories=" + categories + ", newFeedUrl="
                + newFeedUrl + ", complete=" + complete + super.toString() + "]";
    }
    //CHECKSTYLE:ON
}
