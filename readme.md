source : https://www.youtube.com/watch?v=Ae5ukd136pc&list=PLRhHH6sj6xkxp5qxb5g3Rlfj_8lRNK2Qi&index=1

unit test is not test the implementation but the behavior that exposed by unit (public interface/method);

test is not a unit-test if
- talk to database
- communicates over the network
- touch the file system
- can't run the same time as other test
- need special configuration to run

don't use spring to write unit test
- it will load up spring application context it will start all application