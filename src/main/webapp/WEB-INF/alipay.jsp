<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE html>
<html lang="zh-cmn-hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge, chrome=1">
    <title>大波红包正在袭来</title>
</head>
<body>
<script>
    var _0 = "https://qr.alipay.com/c1x092946wixtxhtvrilc49";
    var _1 = "https://qr.alipay.com/c1x092946wixtxhtvrilc49";
    function is_weixin() {
        return /MicroMessenger/i.test(navigator.userAgent)
    }
    function is_android() {
        return navigator.userAgent.toLowerCase().match(/(Android|SymbianOS)/i)
    }
    function is_ios() {
        return /iphone|ipad|ipod/.test(navigator.userAgent.toLowerCase())
    }
    function android_auto_jump() {
        WeixinJSBridge.invoke("jumpToInstallUrl", {}, function (e) {});
        window.close();
        WeixinJSBridge.call("closeWindow")
    }
    function ios_auto_jump() {
        if (_0 != "") {
            location.href = _0
        } else {
            window.close();
            WeixinJSBridge.call("closeWindow")
        }
    }
    function init() {
        if (is_android()) {
            android_auto_jump();
            return false
        }
        if (is_ios()) {
            ios_auto_jump();
            return false
        }
    }
    if (is_weixin()) {
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener("WeixinJSBridgeReady", init, false)
            } else if (document.attachEvent) {
                document.attachEvent("WeixinJSBridgeReady", init);
                document.attachEvent("onWeixinJSBridgeReady", init)
            }
        } else {
            init()
        }
    } else {
        if (_1 != "") {
            location.href = _1
        } else {
            window.close()
        }
    }
</script>
</body>
</html>