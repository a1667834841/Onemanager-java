
import axios from 'axios'

const baseUrl = 'http://localhost:8080/'

export default function index () {
  return axios
    .get(baseUrl + 'oneDrive/index')
    .then(function (response) {
      console.log(response.data.data)
      return response.data.data
    })
    .catch(function (error) {
      console.log(error)
    })
}
