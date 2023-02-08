package com.guo.roy.research.misc.pattern.singleton;

/**
 * @author guojun
 * @date 2021/3/22 下午3:42
 */
public enum SingletonObjectHolder {
    MOCK_OBJECT(new MockObject());

    private MockObject mockObject;

    SingletonObjectHolder(MockObject mockObject) {
        this.mockObject = mockObject;
    }

    public MockObject getMockObject() {
        return mockObject;
    }

    static class MockObject {
        private MockObject() {
        }
    }

}
