'use strict';

var SockJS = require('sockjs-client'); // <1>
require('stompjs'); // <2>


function register(registrations) {
	var socket = SockJS('/payroll'); // <3>
	var stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		registrations.forEach(function (registration) { // <4>
			stompClient.subscribe(registration.route, registration.callback);
		});
	});
}

module.exports.register = register;


/*
 * 1 - pull in SockJS JavaScript library for talking over WebSockets
 * 2 - pull in stomp-websocket js library to use the STOMP sub-protocol
 * 3 - the websocket points to the the applications /payroll endpoint. 
 * 4 - Iterate over the array of registrations supplied so each can subscribe for callback as messages arrive
 * 
 * Each registration entry has a route and a callback. 
 */
