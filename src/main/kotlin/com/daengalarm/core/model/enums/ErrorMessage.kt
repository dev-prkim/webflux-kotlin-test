package com.daengalarm.core.model.enums

enum class ErrorMessage(val message: String) {
    SEARCH_QUERY_PARAM_NOT_FOUND("Search must have query params"),
    INCORRECT_SEARCH_CRITERIA_VALUE("Incorrect search criteria value"),
    INCORRECT_SEARCH_CRITERIA("Incorrect search criteria"),
    DATA_TYPE_ERROR_ID("`id` must be numeric"),
    INVALID_BODY("Invalid body"),
    INTERNAL_ERROR("Internal error")
}