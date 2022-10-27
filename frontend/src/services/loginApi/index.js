import axios from 'axios';
import Axiosinstance from '../../utils/axios';
import BASE_URL from '../base-urls';

const appUsers = {
    async login(...body){
        return await axios.post(`${BASE_URL.loginApiVersion}/login`, ...body)
    },
    async register(...body){
        return await axios.post(`${BASE_URL.loginApi}/app-users/create/`, ...body)
    }
}

const loginApi = {
    appUsers
}

export default loginApi;