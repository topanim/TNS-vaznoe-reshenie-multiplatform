package app.what.gorogeuslugi.features.onboarding.presentation.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingEvents
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingState
import app.what.gorogeuslugi.features.onboarding.presentation.ui.components.AuthorizationPage
import app.what.gorogeuslugi.features.onboarding.presentation.ui.components.LoginPage
import app.what.gorogeuslugi.foundation.core.Listener
import kotlinx.coroutines.launch

@Composable
fun OnboardingView(state: OnboardingState, listener: Listener<OnboardingEvents>) {
    val pageState = rememberPagerState(0) { 2 }
    val scope = rememberCoroutineScope()

    HorizontalPager(
        state = pageState,
        userScrollEnabled = false
    ) { page ->
        when (page) {
            0 -> AuthorizationPage(
                esin = {
                    listener(OnboardingEvents.AuthType(true))
                    scope.launch {
                        pageState.animateScrollToPage(
                            pageState.currentPage + 1, animationSpec =
                                tween(
                                    1000,
                                    easing = FastOutSlowInEasing
                                )
                        )
                    }
                },
                nextPage = {
                    listener(OnboardingEvents.AuthType(false))
                    scope.launch {
                        pageState.animateScrollToPage(
                            pageState.currentPage + 1, animationSpec =
                                tween(
                                    1000,
                                    easing = FastOutSlowInEasing
                                )
                        )
                    }
                })

            1 -> LoginPage(state, listener) {
                scope.launch {
                    pageState.animateScrollToPage(
                        pageState.currentPage - 1, animationSpec =
                            tween(
                                1000,
                                easing = FastOutSlowInEasing
                            )
                    )
                }
            }
        }
    }
}