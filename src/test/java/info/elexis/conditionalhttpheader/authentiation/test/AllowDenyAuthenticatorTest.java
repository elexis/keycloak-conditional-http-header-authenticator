//public class AllowDenyAuthenticatorTest {
//
////	/**
////	 * Test httpHeaderCondition with mathing pattern
////	 */
////	@Test
////	public void testDenyAccessWithHttpHeaderConditionMatch() {
////		String pattern = "Host: localhost:" + AUTH_SERVER_PORT;
////		boolean negateOutcome = false;
////		boolean expectedOutcome = false;
////		denyAccessWithHttpHeader(pattern, negateOutcome, expectedOutcome);
////	}
////
////	/**
////	 * Test httpHeaderCondition with negation and matching pattern
////	 */
////	@Test
////	public void testDenyAccessWithNegateHttpHeaderConditionMatch() {
////		String pattern = "Host: localhost:" + AUTH_SERVER_PORT;
////		boolean negateOutcome = true;
////		boolean expectedOutcome = true;
////		denyAccessWithHttpHeader(pattern, negateOutcome, expectedOutcome);
////	}
////
////	/**
////	 * Test httpHeaderCondition with no matching pattern
////	 */
////	@Test
////	public void testDenyAccessWithHttpHeaderConditionNoMatch() {
////		String pattern = "Host: nolocalhost:" + AUTH_SERVER_PORT;
////		boolean negateOutcome = false;
////		boolean expectedOutcome = true;
////		denyAccessWithHttpHeader(pattern, negateOutcome, expectedOutcome);
////	}
////
////	/**
////	 * Test httpHeaderCondition with negation and no matching pattern
////	 */
////	@Test
////	public void testDenyAccessWithNegateHttpHeaderConditionNoMatch() {
////		String pattern = "Host: nolocalhost:" + AUTH_SERVER_PORT;
////		boolean negateOutcome = true;
////		boolean expectedOutcome = false;
////		denyAccessWithHttpHeader(pattern, negateOutcome, expectedOutcome);
////	}
////
////	/**
////	 * Helper method to configure the Browser flow and call the expected Outcome
////	 * method
////	 */
////	private void denyAccessWithHttpHeader(String httpHeaderPattern, boolean negateOutcome, boolean loginPossible) {
////		final String flowAlias = "browser - httpHeader condition";
////		final String errorMessage = "You are at the wrong location";
////		final String user = "john-doh@localhost";
////
////		Map<String, String> attributeConfigMap = new HashMap<>();
////		attributeConfigMap.put(ConditionalHttpHeaderAuthenticatorFactory.HTTP_HEADER_PATTERN, httpHeaderPattern);
////		attributeConfigMap.put(ConditionalHttpHeaderAuthenticatorFactory.NEGATE_OUTCOME,
////				Boolean.toString(negateOutcome));
////
////		Map<String, String> denyAccessConfigMap = new HashMap<>();
////		denyAccessConfigMap.put(DenyAccessAuthenticatorFactory.ERROR_MESSAGE, errorMessage);
////
////		configureBrowserFlowWithDenyAccessInConditionalFlow(flowAlias,
////				ConditionalHttpHeaderAuthenticatorFactory.PROVIDER_ID, attributeConfigMap, denyAccessConfigMap);
////
////		try {
////			if (loginPossible) {
////
////				final String userId = testRealm().users().search(user).get(0).getId();
////
////				loginUsernameOnlyPage.open();
////				loginUsernameOnlyPage.assertCurrent();
////				loginUsernameOnlyPage.login(user);
////
////				passwordPage.assertCurrent();
////				passwordPage.login("password");
////
////				events.expectLogin().user(userId).detail(Details.USERNAME, user).removeDetail(Details.CONSENT)
////						.assertEvent();
////			} else {
////
////				loginUsernameOnlyPage.open();
////				loginUsernameOnlyPage.assertCurrent();
////				loginUsernameOnlyPage.login(user);
////
////				errorPage.assertCurrent();
////				assertThat(errorPage.getError(), is(errorMessage));
////
////				events.expectLogin().user((String) null).session((String) null).error(Errors.ACCESS_DENIED)
////						.detail(Details.USERNAME, user).removeDetail(Details.CONSENT).assertEvent();
////			}
////		} finally {
////			revertFlows(testRealm(), flowAlias);
////		}
////
////	}
//
//
//}
