var BridgeConnection = function () {
    var bridgeConnected = false,
        intervalHandle = null,
        self = this;

    self.target = null;

    function runPostInit() {
        if (typeof self.target !== 'object') return;
        if (typeof self.targetFnct !== 'string') return;
        if (typeof self.target[self.targetFnct] !== 'function') return;
        self.target[self.targetFnct]();
    }

    function testBridgeConnection() {
        try {
            Bridge.log('Bridge has been established between jQuery and Java backend.');
            bridgeConnected = true;
        } catch (e) {
            return;
        }
        clearInterval(intervalHandle);
        intervalHandle = null;
        runPostInit();
    }

    function initTestBridgeConnection() {
        intervalHandle = setInterval(testBridgeConnection, 50);
    }

    self.init = function () {
        initTestBridgeConnection();
        return self;
    };

    self.addPostInitHandler = function (target, fnct) {
        self.target = target;
        self.targetFnct = fnct;
    };
};