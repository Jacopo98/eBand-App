import axios from 'axios'

const USER_REST_API_URL = 'http://localhost:8080/eventi'

class EventServices{
	getEvent(){
		return axios.get(USER_REST_API_URL);
	}
}

export default new EventServices();