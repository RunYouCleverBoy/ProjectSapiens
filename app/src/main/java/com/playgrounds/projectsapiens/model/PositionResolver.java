package com.playgrounds.projectsapiens.model;

/**
 * A Position Resolver is a class that determines what kind of item should reside in each position.
 */
public interface PositionResolver {
    int get(int position);
}
