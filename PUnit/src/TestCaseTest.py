from PUnit.src.punit.TestCase import TestCase
from PUnit.src.punit.WasRun import WasRun


class TestCaseTest(TestCase):
    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run()
        assert "setUp testMethod tearDown " == test.log

TestCaseTest("testTemplateMethod").run()
