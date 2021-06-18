import api from "@/common/api.service";
export const customerModule={
    state: {
        customers: [],
        displayModal: false,
        tobeuptadedCustomer:{},
    },
    getters: {
        getCustomers(state){
            return state.customers;
        },
        getDisplayModal(state){
            return state.displayModal;
        },
        gettobeuptadedCustomer(state){
            return state.tobeuptadedCustomer;
        }
    },
    mutations: {
        initCustomers(state, customers) {
            state.customers = customers
          },
        addCustomer(state, customer) {
            state.customers.push(customer)
        },
        changeDisplayModal(state,dis){
            if(dis===true){
                state.displayModal=true
            }
            else{
                state.displayModal=false
            }
        },
        updateCustomer(state,tobeuptadedCust){
            state.tobeuptadedCustomer=tobeuptadedCust
        },
        cleanAndUpdateCustomer(state,data){
            let index = state.customers.findIndex(customer => customer.customerId === data.customerId)
            if(index > -1){
              state.customers[index] = data
              state.tobeuptadedCustomer={}
            }
        },
        deleteCustomer(state,id){
            let index = state.customers.findIndex(customer => customer.customerId === id)
            if(index > -1){
              state.customers.splice(index,1)
            }
        }
    },
    actions: {
        initCustomers({commit}){
            api.getAll().then(response=>commit('initCustomers',response.data))
        },
        addCustomer({commit},customer){
            api.save(customer).then(response=>commit('addCustomer',{ customerId : response.data.customerId, ...customer}))
        },
        changeDisplayModal({commit},dis){
            commit('changeDisplayModal',dis)
        },
        updateCustomer({commit},tobeuptadedCust){
            commit('updateCustomer',tobeuptadedCust)
        },
        cleanAndUpdateCustomer({commit},updatedcustomer){
            api.update(updatedcustomer.customerId,updatedcustomer)
            .then(response=>commit('cleanAndUpdateCustomer',response.data))
            .then(alert(`Güncelleme işlemi başarıyla gerçekleşmiştir`))  
        },
        deleteCustomer({commit},id){
            api.delete(id)
            .then(commit('deleteCustomer',id))
            .then(alert(`Silme işlemi başarıyla gerçekleşmiştir`))   
        }
    }
}