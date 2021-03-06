/**
 *  Virtual Momentary 
 *
 *  Copyright 2018 Stephan Hackett
 *
 *
 * 
 */
def version() {"v1.0.20180413"}

metadata {
	definition (name: "Virtual Momentary", namespace: "stephack", author: "Stephan Hackett") {
        capability "Switch"
        capability "Momentary"
	}
	preferences {
	}
}

def push() {
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "momentary", value: "pushed", isStateChange: true)
    runIn(1,toggleMom)
}

def toggleMom(){
    sendEvent(name: "switch", value: "off")
}

def on() {
    push()
}

def off() {
    push()
}

def installed() {
 	initialize()
}

def updated() {
 	initialize()
}

def initialize() {
    state.version = version()
}
