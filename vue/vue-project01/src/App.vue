<template>
  <div>

      <element-view></element-view>
      <link-view></link-view>
      <table-view></table-view>

  </div>
</template>

<script>
import ElementView from './views/element/ElementView.vue'
import LinkView from './views/element/LinkView.vue'
import TableView from './views/element/TableView.vue'
  export default{
  components: { ElementView, LinkView,TableView },
    data: function(){
      return{
        message: "Hello Vue"
      } 
    },
    methods:{

    }

  }

</script>