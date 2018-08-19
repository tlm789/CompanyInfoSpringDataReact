'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const Grid = require('react-bootstrap/lib/Grid');
const Row = require('react-bootstrap/lib/Row');
const Col = require('react-bootstrap/lib/Col');
const Panel = require('react-bootstrap/lib/Panel');
const when = require('when');
const client = require('./client');
const DropdownButton = require('react-bootstrap/lib/DropdownButton');
const MenuItem = require('react-bootstrap/lib/MenuItem');



const follow = require('./follow'); // function to hop multiple links by "rel"

const root = '/api';



class App extends React.Component {
	
	constructor(props){
		super(props);
		this.state = {companyInfo: [], attributes: [], pageSize: 2, links: {}};
		//this.state = {companyInfo: []};
		this.onCreate = this.onCreate.bind(this);
		this.getStockData = this.getStockData.bind(this);
		//this.handleSubmit = this.handleSubmit.bind(this);
		//this.state.pageSize = 2;
		this.getInfo = this.getInfo.bind(this);
		
	}
	
	
		
	onCreate(newCompanyInfo){
		console.log("in onCreate");
		
		follow(client, root, ['companyInformations']).then(companyCollection => {
			return client({
				method: 'POST',
				//path: companyCollection.entity._links.self.href,	
				path: 'api/companyInformations/findInfo',
				entity: newCompanyInfo,
				headers: {'Content-Type': 'application/json'}
			});
		}).then(response => {
			return follow(client, root, [
				{rel: 'companyInformations', params: {'size': this.state.pageSize}}
			]);
		})
		.done(response => {
			//this.setState({companyInfo: response.entity._embedded.companyInformations});
			
			/*if(typeof response.entity._links.last != "undefined") {
				this.onNavigate(response.entity._links.last.href);
			}else {
				this.onNavigate(response.entity._links.self.href);
			}*/
			this.getInfo();
		})
		
		
		//this.getInfo();
		
		/*return (
				<CompanyInfoTable companyInfo={this.state.companyInfo} />
		)*/
		
	}
	
	getStockData(code,compInfo){
		console.log("in getStockData");
		
		follow(client, root, ['companyInformations']).then(companyCollection => {
			return client({
				method: 'POST',
				//path: companyCollection.entity._links.self.href,	
				path: 'api/companyInformations/findStockData',
				entity: code, compInfo,
				headers: {'Content-Type': 'application/json'}
			});
		}).then(response => {
			return follow(client, root, [
				{rel: 'companyInformations', params: {'size': this.state.pageSize}}
			]);
		})
		.done(response => {
			
			this.getInfo();
			console.log("the stocks are " + this.state.companyInfo.stock);
		})
	}
	
	
	
	
	getInfo(){
		
	
		/*client({method: 'GET', path: '/api/companyInformations'}).done(response => {
			this.setState({companyInfo: response.entity._embedded.companyInformations});
			//this.setState({companyInfo: response.entity});
		});*/
		
		follow(client, root, [
			{rel: 'companyInformations', params: {size: this.pageSize}}
		]).then(companyCollection => {
			return client({
				method: 'GET',
				path: companyCollection.entity._links.profile.href,
				headers: {'Accept' : 'application/schema+json'}
			}).then(schema =>{
				this.schema = schema.entity;
				return companyCollection;
			});
		}).done(companyCollection =>{
			this.setState({
				companyInfo: companyCollection.entity._embedded.companyInformations,
				attributes: Object.keys(this.schema.properties),
				pageSize: this.pageSize,
				links: companyCollection.entity._links
			});
		});
			
			
		
	}
	
	/*updatePageSize(pageSize) {
		if (pageSize !== this.state.pageSize) {
			this.loadFromServer(pageSize);
		}
	}*/
	
	componentDidUpdate(){
		
		console.log("in didUpdate");
		
		
		const newCompInfo = this.state.companyInfo.length; 
		console.log("the length of array is " + newCompInfo);
		for(var i = 0; i< newCompInfo; i++){
			console.log("the companyInfo array name is: "+ this.state.companyInfo[i].name);
			console.log("the companyInfo array wiki is: "+ this.state.companyInfo[i].wiki);
		}
		
		//if(typeof this.state.companyInfo != "undefined" && this.state.companyInfo != null && this.state.companyInfo.length > 0){	
				
			//renderInfo;
		
	}
	
	ShouldComponentUpdate(){
		return true;
	}
	
	componentDidMount() {
		this.getInfo();		
		console.log("in componentDidMount");
		console.log("length of state array is "+ this.state.companyInfo.length);
		for(var i = 0; i< this.state.companyInfo.length; i++){
			console.log("the companyInfo array is: "+ this.state.companyInfo[i].name);
			console.log("the companyInfo array is: "+ this.state.companyInfo[i].wiki);
		}
	}
	
	
	render() {
		return (
			<div>
				<Search onCreate={this.onCreate} />
				<CompanyInfoTable companyInfo={this.state.companyInfo} getStockData={this.getStockData} />				
			</div>
		)
	}
	
}




/*class CompanyNameRow extends React.Component {

	render(){
		//const name = this.state.companyInfo.name;	
		return (
				
					<Panel.Heading>
					<Panel.Title toggle>
					{this.props.name}
					</Panel.Title>
					</Panel.Heading> 
					
		
		)
	}

}*/

class InfoRow extends React.Component {
		
	constructor(props) {
	    super(props);
	    this.state = {
	    		stockData: {[]};
	    }
	    this.handleSelect = this.handleSelect.bind(this);
	    this.getStockData = this.props.getStockData;
	    
	}
	
	//create post to worldtrade data
	handleSelect(eventKey) {
	    event.preventDefault();
	    console.log("the checked key is " + eventKey);
	   /* fetch('https://www.worldtradingdata.com/api/v1/history?symbol='+eventKey+'&sort=newest&date_from=2013-01-01&api_token=VmOBMNET2yGQC66i6vVFsu88vhLSj9rLk9kOZDaaIXUUMBvRxDnApmvzA44v')
	    .then(result=>result.json())
	    .then(stockData=>this.setState({stockData}))
	    .then(console.log(this.state.stockData))*/
	    //this.getStockData(eventKey,this.props.compInfo);
	  }
	
	render() {
			
		
		/*const stockCodes = this.props.compInfo.stockCodes.map((item) => {
			
		        	return <option key = {item.symbol}>{item.name},{item.currency}</option>
		})
		
		
		
		const stockCodeForm = [];
		stockCodeForm.push(
			 <div><label htmlFor = "codes" className = "labels">Choose stocks</label> 
			 <select multiple={true}  id = "stockCodeMultiSelect" name = "stockCodes" ref = "stockCodes" style={{width: 100 + '%'}}>
			 {stockCodes}
			 </select></div>
		)*/
		
		
		const stockCurrencyCodes = this.props.compInfo.stockCodes.map((item) => {		
        	return <MenuItem key = eventKey={item.symbol}>{item.name}, {item.currency}</MenuItem>    	
			})
			
		
		const stockCodeDropdown = [];
		const stockData = [];
		
		if(this.props.compInfo.stockCodes !== undefined && this.props.compInfo.stockCodes.length > 0){
			stockCodeDropdown.push(
					<DropdownButton
						bsStyle="info"
				      title="Select Currency for Stock Options to Display"
				      
				      id="stockCodesDropdown"  
				    	  onSelect = {this.handleSelect}
				    	  
				    >
				     {	stockCurrencyCodes
				     }
				    </DropdownButton>	
				   
			);
		}else{
			stockCodeDropdown.push("");
		}
		
		
		if(this.props.compInfo.stock != undefined){
			stockData.push(this.props.compInfo.stock.stocks);
			
		}else{
			stockData.push("");
		}
		if(this.props.compInfo.stock  != undefined){
			for(var i = 0; i<stockData.length; i++){
				console.log("the stockData stocks are" + stockData["stocks"].name);
			}
		}
		
		/*function renderDropdownButton() {
  return (
    <DropdownButton
      bsStyle="Info"
      title="Select Currency to Display"
      key={i}
      id="stockCodesDropdown"   	  
    >
     
    </DropdownButton>
  );
}*/
		
		
		return (
				 
				
	<Panel bsStyle = "info" id = "collapsible-panel-example-2" defaultExpanded>	
		<Panel.Heading>
			<Panel.Title toggle className ="infoHeading">
				{this.props.compInfo.name}
			</Panel.Title>
		</Panel.Heading> 			
			<Panel.Collapse>
				<Panel.Body>
					<table>
						<tbody>
							<tr>
								<td >Overview:</td>
							</tr>
							<tr>
								<td>{this.props.compInfo.wiki}</td>
							</tr>
							<tr>
								<td>Stock Data:</td>
							</tr>
							<tr>
								<td>
							
					      			{stockCodeDropdown}
					      			
								</td>
								
							</tr>
							<tr>
							<td>
						
				      			{stockData}
				      	   
							</td>
							
						</tr>
							<tr>
								<td>Location:</td>
							</tr>
							<tr>
								<td>{this.props.compInfo.location} </td>
							</tr>
							<tr>
								<td>Reviews:</td>
							</tr>
							<tr>
								<td>{this.props.compInfo.reviews}</td>	
							</tr>
						</tbody>
					</table>
				</Panel.Body>
			</Panel.Collapse>
	</Panel>
		);
		
	}
}

class CompanyInfoTable extends React.Component {
	
	constructor(props) {
		super(props);
		this.state = {companyInfo: this.props.companyInfo,
						length: this.props.companyInfo.length};
		this.getStockData = this.props.getStockData;
		
	}
	
	
	componentWillReceiveProps(nextProps){
		if(nextProps.companyInfo !== this.state.companyInfo){
			this.setState({companyInfo: nextProps.companyInfo,
				length: nextProps.companyInfo.length});
		}
		
	}
	
	
		  

	render() {
			
		console.log("in companyInfoTAble the length of state array is "+ this.state.length);
		
		for(var i = 0; i< this.state.length; i++){
			console.log("the companyInfo array name is: "+ this.state.companyInfo[i].name);
			console.log("the companyInfo array wiki is: "+ this.state.companyInfo[i].wiki);
		}
		
		//add if info.stockCodes then push the form and data
		const rows = [];	
				
		if(this.state.companyInfo != null){
			
			this.state.companyInfo.forEach((info) => {
			rows.push (
				<InfoRow compInfo = {info} getStockData = {this.getStockData}
				key = {info._links.self.href} />
			);	
	});
	return (
		
		<Grid>
		<br/>
			<Row>
				<Col lg = {12}>
					<div>
						{rows}
					</div>
				</Col>
			</Row>
		</Grid>
	)
		}else{
			
			return(
					<Grid>
			<Row>
				<Col xs={12} sm = {4} md ={4}>
					<h1>
					"no data";
					</h1>
				</Col>
			</Row>
		</Grid>
		
		)
		}
}
}

class Search extends React.Component{
	//function Search(props){
	constructor(props) {
		super(props);
		
		/*this.state = {
				name:' ',
				types: []
		};*/
		
		//this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.onCreate = this.props.onCreate;
	}
	
		/*handleInputChange(event){
		
		const target = event.target;
		
		if(target.name == "types")
			var types = target.value;
		else
			var companyName = target.value;

	    this.setState({
	      ["name"]: companyName,
	      ["types"]: types
	    });
		
	
		
		//console.log(event.target.name); // the name of the form element
		  //console.log(event.target.value); // the value of the form element
		 var options = event.target.options;
		 var value = [];
		 for(var i = 0, l = options.length; i < l; i++){
			 if(options[i].selected) {
				 value.push(options[i].value);
			 }
		 }
		//this.props.
	}*/
	
	
	handleSubmit(e){
		e.preventDefault();
		var newCompanyInfo = {};
		var select = ReactDOM.findDOMNode(this.refs.types);
		var values = [].filter.call(select.options, function(o) {
		return o.selected;
			}).map(function (o) {
				return o.value;
			});
		
		console.log("company name is" + this.name.value);
		//console.log("types are " + this.types.value);
		console.log("types are ");
		for(var i = 0; i< values.length; i++){
			console.log(values[i]);
		}
		
		/*this.props.attributes.forEach(attribute => {
			newCompanyInfo[attribute]= ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
		});*/
		//var data = {"name":this.name.value,"types":values, "wiki":"initWiki", "financialData": "some data", "location":"43 This Rd", "CEO":"May Jane", "reviews": ["bad company", "good company"] };
		//var data = {"name":this.name.value,"types":values, "wiki":"", "financialData": "", "location":"", "CEO":"", "reviews": [""] };
		var data = {"name":this.name.value,"types":values};
		this.onCreate(data); //post to backend to create info*/
		
		//clear out dialogs inputs
		/*this.props.attributes.forEach(attribute => {
			ReactDOM.findDOMNode(this.refs[attribute]).value = '';
		});*/
	}
	
	
	
	
	
	
	render() {
		
	return (
	<Grid>
		<Row>
			<form onSubmit={this.handleSubmit}>
    			<Col xs ={12} md={4}>   
      			<label htmlFor="name" className = "labels">Enter the exact company name</label>     
      			<input type="text" ref = {input => this.name = input} className="form-control" placeholder="company name"/>      
      		</Col>
   		 
      		<Col xs ={12} md={4}>   
      			<label htmlFor = "types" className = "labels">Choose the type of information</label> 
      			<select multiple={true} id = "myMultiselect" name = "types" ref = "types" style={{width: 100 + '%'}}>    
      				<option value = "1">Company Overview</option>
      				<option value = "2">Latest Stock Price plus Last 5-Year Historical Prices</option>
      				<option value = "3">Financial Data</option>
      				<option value = "4">Location</option>
      				<option value = "5">Reviews</option>
      				<option value = "6">CEO</option>
      				</select>
      		</Col>  
  
      	<Col xs ={12} md={4}>     
      		<label htmlFor = "submit" className = "labels">Display your information</label>      
      		<button type = "submit" className="btn btn-primary" style={{width: 100 + '%'}}>Submit</button>
      	</Col>
  </form>
  </Row>
  </Grid>
  
	);
	}
}



/*class FilterableTable extends React.Component {

	render() {
		return (
			<div>
				<Search />
				<CompanyInfoTable companyInfo={this.props.companyInfo} />
		);
	}
}*/


ReactDOM.render(
		<App />,
		document.getElementById('react')
	);