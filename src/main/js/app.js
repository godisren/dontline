'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

const root = '/api';

class App extends React.Component {
	
	constructor(props) {
		super(props);
		this.state = {rooms: []};
		
		this.loadRoomsFromServer = this.loadRoomsFromServer.bind(this);
	}
	
	componentDidMount() {
		this.loadRoomsFromServer();
	}
		
	loadRoomsFromServer() {
		client({
			method: 'GET',
			//path: employee._links.self.href
			path: 'http://127.0.0.1:8080/api/rooms'
		}).done(result => {
			this.setState({
				rooms: result.entity._embedded.rooms,
			});
		});
	}
	
	render() {
		return (
			<div>
				<RoomBox rooms={this.state.rooms} 
						onRefresh={this.loadRoomsFromServer}/>
			</div>
		)
	}
}

class RoomBox extends React.Component {
	
	constructor(props) {
		super(props);
	}
	
	render() {
		var roomNodes = this.props.rooms.map(function(room) {
		      return (
		    	<Room key={room.roomName} room={room} />
		      );
		    });
		
		return (
	      <div className="wraper roomList" >
	      	<h1>XXX診所</h1>
	      	{roomNodes}
	      	<input type="button" className="btn" onClick={this.props.onRefresh} value="Refresh!" />
	      </div>
	    );
	  }
}

class Room extends React.Component {
	
	render() {
		return (
			<div className="info_div room">
	  	    	<div className="info_header">{this.props.room.roomName}({this.props.room.ownerName})</div>
	  	    	<span className="info_num">{this.props.room.currentNum}</span>
	  	    	<span>{this.props.room.lastModifyDate}</span>
	  	    </div>
	    );
	  }
}


ReactDOM.render(
	<App />,
	document.getElementById('react')
)

