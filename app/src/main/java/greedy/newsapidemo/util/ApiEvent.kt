package greedy.newsapidemo.util

import greedy.newsapidemo.data.network.model.Article

/**
 * Handles api data and based on api executions returns classes such as Success, Error,
 * Loading, Empty.
 *
 * @author shobhit
 * @since  13 Jun 2021
 */
sealed class ApiEvent {
    class Success(val data: List<Article>) : ApiEvent()
    class Error(val message: String) : ApiEvent()
    object Empty : ApiEvent()
    object Loading : ApiEvent()
}