<template>
  <div class="anasayfa">
      <div class="row">
        <div class="col col-sm-4">
          <div class="container">
          <customer-form />
          </div>
        </div>
        <div class="col col-sm-8">
          <div class="container">
          <customer-table />
          </div>
        </div>
      </div>
    <form-modal v-if="displayModal" @close-modal-event="hideModal" />
  </div>
</template>
<script>
import CustomerForm from "@/components/customer/CustomerForm";
import CustomerTable from "@/components/customer/CustomerTable";
import FormModal from "@/components/customer/FormModal";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "Home",
  components: {
    CustomerForm,
    CustomerTable,
    FormModal,
  },
  methods: {
    ...mapActions(["changeDisplayModal"]),
    hideModal() {
      this.changeDisplayModal(false);
    },
  },
  computed: {
    ...mapGetters({ displayModal: "getDisplayModal" }),
  },
};
</script>
<style>
</style>
