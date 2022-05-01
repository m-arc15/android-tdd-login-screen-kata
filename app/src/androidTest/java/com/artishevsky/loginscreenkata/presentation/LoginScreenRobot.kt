package com.artishevsky.loginscreenkata.presentation

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import com.artishevsky.loginscreenkata.base.BaseScreenRobot

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val emailInput by lazy { composeTestRule.onNodeWithTag("emailTextField") }
    private val passwordInput by lazy { composeTestRule.onNodeWithTag("passwordTextField") }
    private val repeatedPasswordInput by lazy { composeTestRule.onNodeWithTag("repeatedTextField") }

    fun isEmailInputDisplayed() = emailInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_email_input_text)))

    fun isPasswordInputDisplayed() = passwordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_password_input_text)))

    fun isRepeatedPasswordInputDisplayed() = repeatedPasswordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_repeated_password_text)))
}

internal fun BaseAndroidComposeTest.loginScreen(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)