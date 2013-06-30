#ifndef __RATIONAL_TEST_H__
#define __RATIONAL_TEST_H__

#include <io/humble/testutils/TestUtils.h>
#include <io/humble/ferry/RefPointer.h>
#include <io/humble/video/IRational.h>

using namespace VS_CPP_NAMESPACE;

class RationalTest : public CxxTest::TestSuite
{
  public:
    void setUp();
    void testCreationAndDestruction();
    void testReduction();
    void testGetDouble();
    void testMultiplication();
    void testAddition();
    void testSubtraction();
    void testDivision();
    void testConstructionFromNumeratorAndDenominatorPair();
    void testRescaling();
  private:
    io::humble::ferry::RefPointer<IRational> num;
};


#endif // __RATIONAL_TEST_H__
