cdp4j -  Automation library for Chromium based Browsers
=========================================================

cdp4j is **Java** library with a clear and concise API to automate Chrome/Chromium based browser.
It use [Google Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/) to automate Chrome/Chromium based browsers.

What can you do with cdp4j?
---------------------------
Most things that you can do manually in the browser can be done using cdp4j.
Here are a few examples to get you started:

* Generate screenshots and PDFs of pages.
* Crawl a Single-Page Application and generate pre-rendered content (Server-Side Rendering).
* Automate form submission, UI testing, keyboard input, etc.
* Create an up-to-date, automated testing environment.
* Run your tests directly in the latest version of Chromium using the latest JavaScript and browser features.

How to run examples?
--------------------
1. Download the [archive](https://github.com/webfolderio/cdp4j/archive/refs/heads/master.zip) file.
2. Extract the archive file.
3. Launch the [Eclipse IDE](https://www.eclipse.org/ide/) and import the project (*File -> Import > Existing Projects into Workspace*)
4. Launch the Intellij and [import the Eclipse project](https://www.jetbrains.com/help/idea/import-project-from-eclipse-page-1.html).

Major Features
-------------
* Supports full capabilities of the Chrome DevTools Protocol ([tip-of-tree](https://chromedevtools.github.io/debugger-protocol-viewer/tot/))
* PDF printer
* Evaluate JavaScript
* Invoke JavaScript function
* Invoke Java function from Browser (JavaScript)
* Supports native CSS selector engine
* Supports Playwright [selectors](https://playwright.dev/docs/selectors)
* iframe support
* Supports XPath queries
* Incognito Browsing (private tab)
* Full page screen capture
* Support parallel running
* Auto-Wait for DOM change completion
* Trigger Mouse events (click etc...)
* Send keys (text, tab, enter etc...)
* Redirect log entries (javascript, network, storage etc...) from browser to slf4j, log4j, jul, log4j2 or console logger.
* Intercept Network traffic (request & response)
* Upload file programmatically without third party solutions (does not requires AWT Robot etc...)
* Get & set Element properties
* Supports Headless Chrome/Chromium
* Navigate back, forward, stop, reload
* Clear cache, clear cookies, list cookies
* Set & get values of HTML form elements
* Supports DOM event handling
* Supports all well known Java WebSocket libraries.

Supported Java Versions
-----------------------

Oracle/OpenJDK 8+, GraalVM & native-image.

Both the JRE and the JDK are suitable for use with this library.

Stability
---------
This library is suitable for use in production systems. Our library is used by many well known enterprise customers.

Supported Platforms
-------------------
cdp4j has been tested under Windows 10 and Ubuntu, but should work on any platform where a Java 8+/Graal VM native-image & Chrome/Chromium/Microsoft Edge available.

__Note__: Although we do not execute test suites on Mac, many customers run cdp4j without any problem. Please do not hesitate to report bugs related with Mac.

Release Notes
-------------
[CHANGELOG.md](https://github.com/webfolderio/cdp4j/blob/master/CHANGELOG.md)

Headless Mode
-------------
cdp4j can be run in "headless" mode using with `Options.headless(boolean)` option.

JavaDoc
-------
[cdp4j api](https://webfolder.io/cdp4j/javadoc/index.html)

Logging
-------
slf4j 1.x, log4j 1.x, JUL and custom Console logger is supported.

__Note:__ Please let us know if your preferred logging library is not listed.

WebSocket Protocol
------------------
DevTools Protocol uses WebSocket protocol to automate Chromium based browser. We supports the following Java WebSocket libraries.

* Jre WebSocket Library (requires Java 11+).
* Jetty
* Undertow
* Vertx
* Tyrus
* TooTallNateWebSocket
* Tomcat
* Netty
* NvWebSocket
* libuv

__Note:__ Please let us know if your preferred WebSocket library is not listed.

Examples
-------
We provide many [examples](https://github.com/webfolderio/cdp4j/tree/master/src/io/webfolder/cdp/sample) to show how to use cdp4j library.
It's highly recommended to run these examples before starting to use cdp4j.

Design Principles
-----------------
* Avoid external dependencies as much as possible.
* Support only Chrome/Chromium based browsers.
* Supports full capabilities of the Chrome DevTools Protocol.
* Keep the API simple.
* Support GraalVM Native Image.

How it is tested
----------------
cdp4j is regularly built and tested on Windows 10, Ubuntu, Centos and macOS.

Support & Bug Report
--------------------
Please report your bugs and new features by e-mail ([support@webfolder.io](mailto:support@webfolder.io)).
GitHub issues is only used by cdp4j developers.

