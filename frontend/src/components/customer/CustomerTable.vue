<template>
      <div class="CustomerTable">
        <table v-if="customers.length > 0" class="table table-hover table-bordered border-primary table-responsive">
          <thead>
          <tr>
            <th scope="col">S.NO</th>
            <th scope="col">İsim</th>
            <th scope="col">Soyisim</th>
            <th scope="col">Yabancı Dil</th>
            <th scope="col">Cinsiyet</th>
            <th scope="col">Telefon Numarası</th>
            <th scope="col">Email</th>
            <th scope="col">Doğum Günü</th>
            <th scope="col">Düzenle</th>
            <th scope="col">Sil</th>
          </tr>
          </thead>
          <tbody>
            <Customer v-for="(customer,index) in customers" :key="index" :index="index" :customer="customer" />
          </tbody>
        </table>
        <div v-else class="alert alert-primary border-0">
          Henüz eklenmiş bir kişi bulunmamaktadır.
        </div>
      </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";
import Customer from '@/components/customer/Customer'

export default {
    name: 'CustomerTable',
    components:{
     Customer
    },
    methods: {
        ...mapActions(['initCustomers']),

    },
    created(){
        this.initCustomers();
    },
    computed: {
        ...mapGetters({customers:'getCustomers'})
    }
  };
</script>
<style scoped>
    .CustomerTable{
   background-color:coral;
   color: black;
   font-size: 16px;

  }
</style>
