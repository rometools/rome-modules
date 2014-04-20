/*
 * EntryInformation.java
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
package org.rometools.feed.module.itunes;

import org.rometools.feed.module.itunes.types.Duration;

import com.sun.syndication.feed.CopyFrom;

/**
 * This class contains information for iTunes podcast feeds that exist at the Item level.
 * 
 * @version $Revision: 1.2 $
 * @author <a href="mailto:cooper@screaming-penguin.com">Robert "kebernet" Cooper</a>
 */
public class EntryInformationImpl extends AbstractITunesObject implements EntryInformation {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Duration duration;
    private ClosedCaptioned closedCaptioned;
    private Integer order;

    /**
     * Creates a new instance of EntryInformationImpl.
     */
    public EntryInformationImpl() {
    }

    @Override
    public ClosedCaptioned getClosedCaptioned() {
        return closedCaptioned;
    }

    @Override
    public void setClosedCaptioned(final ClosedCaptioned closedCaptioned) {
        this.closedCaptioned = closedCaptioned;
    }

    /**
     * Returns the Duration object for this Item.
     * 
     * @return Returns the Duration object for this Item
     */
    @Override
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the Duration object for this Item.
     * 
     * @param duration Sets the Duration object for this Item
     */
    @Override
    public void setDuration(final Duration duration) {
        this.duration = duration;
    }

    @Override
    public Integer getOrder() {
        return order;
    }

    @Override
    public void setOrder(final Integer order) {
        this.order = order;
    }

    /**
     * Defined by the ROME module API.
     * 
     * @param obj Object to copy from
     */
    @Override
    public void copyFrom(final CopyFrom obj) {
        final EntryInformationImpl info = (EntryInformationImpl) obj;
        setAuthor(info.getAuthor());
        setBlock(info.getBlock());
        setClosedCaptioned(info.getClosedCaptioned());
        if (info.getDuration() != null) {
            setDuration(new Duration(info.getDuration().getMilliseconds()));
        }
        setExplicit(info.getExplicit());
        setImage(info.getImage());
        if (info.getKeywords() != null) {
            setKeywords(info.getKeywords().clone());
        }
        setOrder(info.getOrder());
        setSubtitle(info.getSubtitle());
        setSummary(info.getSummary());
    }

    /**
     * Required by the ROME API.
     * 
     * @return A clone of this module object
     */
    @Override
    public Object clone() {
        final EntryInformationImpl info = new EntryInformationImpl();
        info.copyFrom(this);

        return info;
    }

    //CHECKSTYLE:OFF
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (closedCaptioned == null ? 0 : closedCaptioned.hashCode());
        result = prime * result + (duration == null ? 0 : duration.hashCode());
        result = prime * result + (order == null ? 0 : order.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntryInformationImpl other = (EntryInformationImpl) obj;
        if (closedCaptioned != other.closedCaptioned) {
            return false;
        }
        if (duration == null) {
            if (other.duration != null) {
                return false;
            }
        } else if (!duration.equals(other.duration)) {
            return false;
        }
        if (order == null) {
            if (other.order != null) {
                return false;
            }
        } else if (!order.equals(other.order)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntryInformationImpl [duration=" + duration + ", closedCaptioned=" + closedCaptioned + ", order=" + order + super.toString() + "]";
    }
    //CHECKSTYLE:ON
}
