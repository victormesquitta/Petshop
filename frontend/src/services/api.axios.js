import axios from "axios";

const urlBackend = "http://localhost:8080/api";

const backend = axios.create({
    baseUrl: urlBackend
  });

export { backend };