import{H as S}from"./header-ce1ba502.js";import{F as k}from"./footer-0b848f08.js";import{a as D,u as C,y as b,b as z,j as P,C as B,B as I,r as f,o as r,e as d,f as t,t as _,g as a,k as l,s as F,F as V,l as $,p as q,h as E}from"./index-f6b5f6b4.js";import{l as L}from"./thing-6c3202c7.js";import{_ as w}from"./_plugin-vue_export-helper-c27b6911.js";import"./notice-502f1323.js";import"./k-logo-98944f67.js";const h=i=>(q("data-v-c422de9e"),i=i(),E(),i),R={class:"content-margin"},U={class:"search-name-box"},A={class:"search-tab-nav clearfix"},H={class:"tab-text"},N=h(()=>t("span",null,"与",-1)),j={class:"strong"},M=h(()=>t("span",null,"相关的内容",-1)),O={class:"content-list"},T={class:"thing-list"},G={class:"things flex-view"},J=["onClick"],K={class:"img-view"},Q=["src"],W={class:"info-view"},X={class:"thing-name"},Y=h(()=>t("span",{class:"a-price-symbol"},"¥",-1)),Z={class:"a-price"},ee={class:"page-view",style:{}},te={__name:"search-content-view",setup(i){D();const g=C(),p=b(),e=z({loading:!1,keyword:"",thingData:[],pageData:[],page:1,total:0,pageSize:20});P(()=>{u()}),B(()=>p.query,(o,s)=>{u()},{immediate:!1});const u=()=>{e.keyword=p.query.keyword.trim(),x({keyword:e.keyword})},v=o=>{e.page=o;let s=(e.page-1)*e.pageSize;e.pageData=e.thingData.slice(s,s+e.pageSize),console.log("第"+e.page+"页")},y=o=>{let s=g.resolve({name:"detail",query:{id:o.id}});window.open(s.href,"_blank")},x=o=>{e.loading=!0,L(o).then(s=>{s.data.forEach((c,m)=>{c.cover&&(c.cover=I+"/api/staticfiles/image/"+c.cover)}),e.thingData=s.data,e.total=e.thingData.length,v(1),e.loading=!1}).catch(s=>{console.log(s),e.loading=!1})};return(o,s)=>{const c=f("a-spin"),m=f("a-pagination");return r(),d("div",R,[t("h1",U,_(a(e).keyword),1),t("div",A,[t("div",H,[N,t("span",j,_(a(e).keyword),1),M])]),t("div",O,[t("div",T,[l(c,{spinning:a(e).loading,style:{"min-height":"200px"}},{default:F(()=>[t("div",G,[(r(!0),d(V,null,$(a(e).pageData,n=>(r(),d("div",{class:"thing-item item-column-4",onClick:ie=>y(n)},[t("div",K,[t("img",{src:n.cover},null,8,Q)]),t("div",W,[t("h3",X,_(n.title.substring(0,12)),1),t("span",null,[Y,t("span",Z,_(n.price),1)])])],8,J))),256))])]),_:1},8,["spinning"]),t("div",ee,[l(m,{value:a(e).page,"onUpdate:value":s[0]||(s[0]=n=>a(e).page=n),size:"small",onChange:v,hideOnSinglePage:!0,defaultPageSize:a(e).pageSize,total:a(e).total},null,8,["value","defaultPageSize","total"])])])])])}}},se=w(te,[["__scopeId","data-v-c422de9e"]]);const ae={class:"search"},oe={class:"search-content"},ne={__name:"search",setup(i){return(g,p)=>(r(),d("div",ae,[l(S),t("div",oe,[l(se)]),l(k)]))}},ge=w(ne,[["__scopeId","data-v-921c279a"]]);export{ge as default};
