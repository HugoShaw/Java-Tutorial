package assignment8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Entity {
	
	private boolean isZombie;
	private double x;
	private double y;
	
	private double radius = 0.008;

	/**
	 * @param isZombie the undead state of this Entity.
	 *                 true if zombie, false otherwise.
	 * @param x        the x-coordinate of this Entity's center.
	 * @param y        the y-coordinate of this Entity's center.
	 */
	public Entity(boolean isZombie, double x, double y) {
		this.isZombie = isZombie;
		this.x = x;
		this.y = y;		
	}

	/**
	 * @return true if zombie, false otherwise
	 */
	public boolean isZombie() {
		return this.isZombie;
	}

	/**
	 * @return the center x-coordinate
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * @return the center y-coordinate
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Draw this Entity.
	 */
	public void draw() {
		if (isZombie()) {
			StdDraw.setPenColor(StdDraw.RED);;
		} else {
			StdDraw.setPenColor(StdDraw.BLACK);
		}
		StdDraw.filledCircle(getX(), getY(), getRadius());
	}

	

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @return distance between this Entity's center and the specified other point.
	 */
	public double distanceCenterToPoint(double xOther, double yOther) {
		return Math.sqrt(Math.pow(getX() - xOther, 2) + Math.pow(getY() - yOther, 2));
	}

	/**
	 * @param other the other Entity
	 * @return the distance between this Entity's center and the specified other
	 *         Entity's center.
	 */
	public double distanceCenterToCenter(Entity other) {
		return distanceCenterToPoint(other.getX(), other.getY());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(double xOther, double yOther, double radiusOther) {
		return distanceCenterToPoint(xOther, yOther) - getRadius() - radiusOther;
	}

	/**
	 * @param other the other Entity.
	 * @return the distance between this Entity's edge and the specified other
	 *         Entity's edge.
	 */
	public double distanceEdgeToEdge(Entity other) {
		return distanceEdgeToEdge(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther      the x-coordinate of another Entity's center.
	 * @param yOther      the y-coordinate of another Entity's center.
	 * @param radiusOther the radius of another Entity.
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(double xOther, double yOther, double radiusOther) {
		return distanceEdgeToEdge(xOther, yOther, radiusOther) <= 0;
	}

	/**
	 * @param other the other Entity
	 * @return true if the bounding circle of this Entity overlaps with the bounding
	 *         circle of the specified other Entity, false otherwise.
	 */
	public boolean isTouching(Entity other) {
		return isTouching(other.getX(), other.getY(), other.getRadius());
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move toward the point.
	 */
	public void moveToward(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);

		this.x += xAmount;
		this.y += yAmount;	

	}

	/**
	 * @param other  the other Entity
	 * @param amount the amount to move toward the other Entity.
	 */
	public void moveToward(Entity other, double amount) {
		moveToward(other.getX(), other.getY(), amount);
	}

	/**
	 * @param xOther x-coordinate of the other point.
	 * @param yOther y-coordinate of the other point.
	 * @param amount the amount to move away from the point.
	 */
	public void moveAwayFrom(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);
		
		this.x -= xAmount;
		this.y -= yAmount;		
		
//		if (this.x < 0) {
//			this.x=0;
//		}
//		if (this.x > 1) {
//			this.x=1;
//		}
//		if (this.y < 0) {
//			this.y=0;
//		}
//		if (this.y > 1) {
//			this.y=1;
//		}
	}

	/**
	 * @param other  the other Entity
	 * @param amount the amount to move away from the other Entity.
	 */
	public void moveAwayFrom(Entity other, double amount) {
		moveAwayFrom(other.getX(), other.getY(), amount);
	}

	/**
	 * @param entities          this list of entities to search.
	 * @param includeZombies    whether to include zombies in this search or not.
	 * @param includeNonzombies whether to include nonzombies in this search or not.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	private Entity findClosest(List<Entity> entities, boolean includeZombies, boolean includeNonzombies) {
		Entity closest = null;
		double closestDist = Double.MAX_VALUE;
		for (Entity other : entities) {
			// NOTE:
			// We almost always want to use the equals method when comparing Objects.
			// In this case, we check if the two entities are the exact same instance.
			if (this != other) {
				if ((other.isZombie() && includeZombies) || (!other.isZombie() && includeNonzombies)) {
					double dist = distanceEdgeToEdge(other);
					if (dist < closestDist) {
						closest = other;
						closestDist = dist;
					}
				}
			}
		}
		return closest;
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest nonzombie to this Entity in entities (which is not this).
	 */
	public Entity findClosestNonzombie(List<Entity> entities) {
		return findClosest(entities, false, true);
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest zombie to this Entity in entities (which is not this).
	 */
	public Entity findClosestZombie(List<Entity> entities) {
		return findClosest(entities, true, false);
	}

	/**
	 * @param entities this list of entities to search.
	 * @return the closest Entity to this Entity in entities (which is not this).
	 */
	public Entity findClosestEntity(List<Entity> entities) {
		return findClosest(entities, true, true);
	}

	

	/**
	 * Updates the appropriate state (instance variables) of this Entity for the
	 * current frame of the simulation.
	 * 
	 * @param entities  list of remaining entities in the simulation. It is likely
	 *                  that this Entity will be one of the entities in the list.
	 *                  Care should be taken to not overreact to oneself.
	 * @param deltaTime the change in time since the previous frame
	 * 
	 * @return true if this Entity remains in existence past the current frame,
	 *         false if consumed
	 *         
	 * 1. Entity update for zombies requirements: if entity is a zombie, move towards the closest non-zombie
	 * 		- find a closest non zombie
	 * 			a. if not find, then find a closest entity / zombie
	 * 				i) if find, then walk towards the zombie
	 * 					* if touching, then eat the zombie
	 * 			b. if find, then move towards the non zombie
	 * 				i) if touching, then 80% containment it, 20% eat it and become bigger
	 * 2. Entity update for non-zombie requirements: if non zombie, move away from all entities
	 * 
	 * 		- find a closest zombie
	 * 			a. if not find, find the closest entity / non zombie
	 * 				i) if find, move away
	 * 				ii) check the closest zombie and check if touched or not
	 * 					* touched, then 80% became a zombie, 20% ate
	 *                  * not touched, then true
	 * 			b. if find, then move away from the zombies
	 * 				ii) check if touched or not
	 * 					* touched, then 80% became a zombie, 20% ate
	 * 					* not touched, then true
	 *        
	 */
	public boolean update(List<Entity> entities, double deltaTime) {
		double distAmount = Math.random() * deltaTime;
		// zombie is seeking for a non-zombie
		if (this.isZombie()) {
			// nonzombie: try to containminate
			// zombie: eat the zombie
			// 1. try to find the non-zombie
			Entity otherNonZombie = this.findClosestNonzombie(entities);
			if (otherNonZombie == null) { // not find the non-zombie
				// seek for other entities (zombies)
				Entity otherEntity = this.findClosestEntity(entities);
				if (otherEntity != null) { // if we find an entity (zombie), we walk towards it
					// check if touched by a zombie 
					if (this.isTouching(otherEntity) && otherEntity.isZombie()) { // if touched by zombie, died
						return false;
					} else { // not touched by other zombies, walk towards other zombies
						this.moveToward(otherEntity, distAmount);
						if (this.x < 0) {
							this.x=0;
						} else if (this.x > 1) {
							this.x=1;
						}
						if (this.y < 0) {
							this.y=0;
						}else if (this.y > 1) {
							this.y=1;
						}
						// after moving towards
						Entity closestEntity = this.findClosestEntity(entities); // new position and find closest one
						if (closestEntity != null && this.isTouching(closestEntity) && closestEntity.isZombie()) { // if touch other entity (zombie), eat it
							this.radius += 0.001;
						} else if (closestEntity != null && this.isTouching(closestEntity) && !closestEntity.isZombie()) { // touch a non-zombie
							if (Math.random() < 0.2) { // 20% eat it
								this.radius += 0.01;
							}
						}
						return true;
					}
				} // else there is no closest entity found still return true
				return true;
			} else { // find a non-zombie
				// check if touched the non-zombie
				if (this.isTouching(otherNonZombie)) { // touch the non-zombie, 80% make it as a zombie
					if (Math.random() < 0.2) { // 20% eat it
						this.radius += 0.01;
					}
					return true;
				} else { // not touched the non-zombie yet
					// walk towards to non-zombie
					this.moveToward(otherNonZombie, distAmount);
					if (this.x < 0) {
						this.x=0;
					} else if (this.x > 1) {
						this.x=1;
					}
					if (this.y < 0) {
						this.y=0;
					}else if (this.y > 1) {
						this.y=1;
					}
					// after moving towards
					Entity closestEntity = this.findClosestEntity(entities);
					if (closestEntity != null && this.isTouching(closestEntity) && !closestEntity.isZombie()) { // touch the non-zombie, 80% make it as a zombie
						if (Math.random() < 0.2) { // 20% eat it
							this.radius += 0.01;
						}
					} else if (closestEntity != null && this.isTouching(closestEntity) && closestEntity.isZombie()) {
						this.radius += 0.001;
					}
					return true;
				}
			}
			
		} else { // this is a non-zombie
			// find a zombie and move away
			Entity otherZombie = this.findClosestZombie(entities);
			if (otherZombie == null) { // if not find the zombie, find closest entity and move away
				Entity otherEntity = this.findClosestEntity(entities);
				// if find an entity / non-zombie
				if (otherEntity != null) {
					this.moveAwayFrom(otherEntity, distAmount); //move away
					if (this.x < 0) {
						this.x=0;
					} else if (this.x > 1) {
						this.x=1;
					}
					if (this.y < 0) {
						this.y=0;
					}else if (this.y > 1) {
						this.y=1;
					}
					// move and check the closest zombie touched or not
					Entity closestZombie = this.findClosestZombie(entities);
					if (closestZombie != null && this.isTouching(closestZombie)) {
						if (Math.random() < 0.8) {// 80 % become a zombie
							this.isZombie = true;
						} else { // 20% dead
							return false;
						}
					}
					return true; // no zombie
				}
				// no entity found
				return true;
			} else { // if find a zombie, move away
				// check if touching
				if (this.isTouching(otherZombie)) {
					if (Math.random() < 0.8) {// 80 % become a zombie
						this.isZombie = true;
					} else { // 20% dead
						return false;
					}
					return true;
				} else { // not touching yet
					this.moveAwayFrom(otherZombie, distAmount);
					if (this.x < 0) {
						this.x=0;
					} else if (this.x > 1) {
						this.x=1;
					}
					if (this.y < 0) {
						this.y=0;
					}else if (this.y > 1) {
						this.y=1;
					}
					// check the closest zombie
					Entity closestZombie = this.findClosestZombie(entities);
					if (closestZombie != null && this.isTouching(closestZombie)) {
						if (Math.random() < 0.8) {// 80 % become a zombie
							this.isZombie = true;
						} else { // 20% dead
							return false;
						}
					}
					return true; // no closest zombie or not be ate
				}
			}	
		}	
	}
	
	
}
