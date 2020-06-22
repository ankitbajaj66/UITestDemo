package com.example.uitestdemo

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 *Created by Ankit Bajaj on 22-06-2020.
 */

// Test Suite is run all the test classes at same time.
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class, SecondaryActivityTest::class
)
class ActivityTestSuite {
}