import axios from 'axios'
class TutorialDataService {
     getAll() {
        return axios.get("/customers").catch(err =>{
            throw new Error("Get İşleminde Hata Meydana Geldi"+err)
        });
    }
    get(id) {
        return axios.get(`/customer/${id}`).catch(err=>{
            throw new Error("Get İşleminde Hata Meydana Geldi"+err)
        });
    }

    save(data) {
        return axios.post("/addCustomer", data).catch(err=>{
            throw new Error("Post İşleminde Hata Meydana Geldi"+err)
        });
    }

    update(id, data) {
            return axios.put(`/updateCustomer/${id}`, data).catch(err=>{
                throw new Error("Put İşleminde Hata Meydana Geldi"+err)
            });
    }

    delete(id) {
        return axios.delete(`/deleteCustomer/${id}`).catch(err=>{
            throw new Error("Delete İşleminde Hata Meydana Geldi"+err)
        });
    }
}

export default new TutorialDataService();