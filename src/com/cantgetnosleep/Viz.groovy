package com.cantgetnosleep

import static groovyx.net.http.ContentType.TEXT
import static groovyx.net.http.Method.GET
import groovy.util.logging.Log4j
import groovyx.net.http.HTTPBuilder

@Log4j
class Viz {

    int port = 9222

    HTTPBuilder http = new HTTPBuilder( 'http://localhost:$port' )

    static main(args) {

        Viz viz = new Viz()
        viz.go()

    }

    void go() {

        println "Starting..."

        killAllChrome()
        startChromeForDebugging()

        println "Finishing..."

    }

    void killAllChrome() {
        println "Killing Chrome"
        def process = "killall 'Google Chrome'".execute()
        process.in.eachLine { line -> println line }
    }

    void startChromeForDebugging() {
        "open -a 'Google Chrome' --args --remote-debugging-port=${port}&".execute()
    }

    void checkAvailableWindows() {

    }


}
