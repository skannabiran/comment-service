package com.maveric.techhub.comment.util;

import java.util.UUID;

public class ServiceConstants {

    public static final String ID_IS_MANDATORY = "ID is mandatory";
    public static final String TYPE_IS_MANDATORY = "Type is mandatory";

    public static final String COMMENT_IS_MANDATORY = "Title is mandatory";

    public static final String TYPE_ID_IS_MANDATORY = "Description is mandatory";

    public static final String COMMENTED_BY_MANDATORY = "commentedBy is mandatory";

    public static final String IDEA_OR_PROJECT = "Type must be Idea or Project";

    public static final String ENTITY_NOT_FOUND = "Entity not found for the given id - %s";

    public static final String ENTITY_DELETED = "Entity deleted for the given id - %s";
    public static String _UUID(){ return UUID.randomUUID().toString(); }
}
