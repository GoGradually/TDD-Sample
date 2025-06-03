from PUnit.src.punit.TestCase import TestCase


class WasRun(TestCase):
    def __init__(self, name):
        super().__init__(name)

    def setUp(self):
        self.log = "setUp "

    def testMethod(self):
        self.wasRun = 1
        self.log = self.log + "testMethod "

    def tearDown(self):
        self.log = self.log + "tearDown "