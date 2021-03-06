/*
 * This file is part of Vanilla (http://www.spout.org/).
 *
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.event.entity;

import org.spout.api.entity.Entity;
import org.spout.api.event.Cancellable;
import org.spout.api.event.HandlerList;
import org.spout.api.event.entity.EntityEvent;
import org.spout.api.exception.InvalidControllerException;
import org.spout.vanilla.entity.living.passive.Pig;

/*
 * Called when a pig is zapped.
 */
public class PigZapEvent extends EntityEvent implements Cancellable {
	private static HandlerList handlers = new HandlerList();

	private Entity pigZombie;

	private Entity lightning;

	public PigZapEvent(Entity e, Entity lightning, Entity pigZombie) throws InvalidControllerException {
		super(e);
		if (!(e.getController() instanceof Pig))
			throw new InvalidControllerException();
		this.lightning = lightning;
		this.pigZombie = pigZombie;
	}

	/*
	 * This gets the entity that represents the lightning that caused the transformation of a pig.
	 * @return an Entity that represents the lightning.
	 */
	public Entity getLightning() {
		return lightning;
	}

	/*
	 * This sets the entity that represents the lightning that caused the transformation of a pig.
	 * @param lightning an Entity that represents the lightning.
	 */
	public void setLightning(Entity lightning) {
		this.lightning = lightning;
	}

	/*
	 * This gets the entity that represents the newly created pig zombie
	 * @return an Entity that represents the pig zombie.
	 */
	public Entity getPigZombie() {
		return pigZombie;
	}

	/*
	 * This sets the entity that represents the newly created pig zombie
	 * @param pigzombie an Entity that represents the newly created pig zombie.
	 */
	public void setPigZombie(Entity pigZombie) {
		this.pigZombie = pigZombie;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		super.setCancelled(cancelled);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
