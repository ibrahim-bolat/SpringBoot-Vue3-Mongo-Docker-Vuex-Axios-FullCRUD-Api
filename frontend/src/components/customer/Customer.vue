<template>
  <tr>
    <td>{{ index+1 }}</td>
    <td>{{ customer.customerName }}</td>
    <td>{{ customer.customerSurName }}</td>
    <td>{{ customer.language }}</td>
    <td>{{ customer.gender }}</td>
    <td>{{ customer.phoneNumber }}</td>
    <td>{{ customer.email }}</td>
    <td>{{ format_date(customer.birthofDate) }}</td>
    <td>
      <button type="button" class="btn btn-primary" @click="showModal();updateCustomer(customer)">Düzenle</button>
    </td>
    <td><button type="button" class="btn btn-danger" @click="deleteCust(customer.customerId)">Sil</button></td>
  </tr>
</template>

<script>
import moment from "moment";
import { mapActions } from "vuex";

export default {
  name: "Customer",
  props: ["customer","index"],
  data() {
    return {
      displayModal: false,
    };
  },
  methods: {
    ...mapActions(['changeDisplayModal','updateCustomer','deleteCustomer']),
    showModal() {
      this.changeDisplayModal(true);
    },
    deleteCust(id) {
      this.deleteCustomer(id);
    },
    format_date(value) {
      return moment(value).format("DD/MM/YYYY");
    }
  },
};
</script>
<style scoped>
.backSet{
opacity:0.5;
}
</style>
