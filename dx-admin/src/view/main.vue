<template>
  <div>
    <headerbar></headerbar>
    <section>
      <leftbar></leftbar>
      <article>
        <router-view></router-view>
      </article>
    </section>
  </div>
</template>

<script>
  import {header, left} from "@/components";

  export default {
    components: {
      headerbar: header,
      leftbar: left,
    },
  }
</script>

<style scoped>

</style>
