var BridgeConnection = function () {
    var bridgeConnected = false;
    var intervalHandle = null;
    var self = this;

    self.testBridgeConnection = function () {
        try {
            Bridge.log('Bridge has been established between jQuery and Java backend.');
            bridgeConnected = true;
        } catch (e) {
            return;
        }
        clearInterval(intervalHandle);
        intervalHandle = null;
    };

    self.exitApp = function () {
        if (!bridgeConnected) return;
        Bridge.exit();
    };

    function testBridgeConnection() {
        intervalHandle = setInterval(self.testBridgeConnection, 50);
    }

    function exitApp() {
        self.exitApp();
    }

    self.init = function () {
        testBridgeConnection();
        $(document).on('click', '#exit-app', exitApp);
        return self;
    };
};