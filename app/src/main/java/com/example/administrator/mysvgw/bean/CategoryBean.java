package com.example.administrator.mysvgw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by whq on 2018/1/4.
 */

public class CategoryBean implements Serializable {
        /**
         * cateName : 全球精选
         * cateImg : http://www.svgouwu.com//data/cate_image/15087242366726.jpg
         * cateId : 2102
         * cateImage : icon-quanqiugouquanqiuzhicai
         居家优品
         icon-quanqiugouquanqiuzhicai
         * classify_rank : 1
         * brand : []
         * children : [{"cateName":"母婴用品","cateImg":"http://www.svgouwu.com//data/cate_image/15034664414782.jpg","cateId":3648,"cateImage":"","classify_rank":2,"children":[{"cateName":"纸尿裤","cateImg":null,"cateId":2103,"cateImage":"","classify_rank":3},{"cateName":"成人尿裤","cateImg":null,"cateId":2104,"cateImage":"","classify_rank":3},{"cateName":"拉拉裤","cateImg":null,"cateId":2105,"cateImage":"","classify_rank":3},{"cateName":"婴儿床","cateImg":null,"cateId":2107,"cateImage":"","classify_rank":3},{"cateName":"学步车","cateImg":null,"cateId":2108,"cateImage":"","classify_rank":3},{"cateName":"滑板车","cateImg":null,"cateId":2109,"cateImage":"","classify_rank":3},{"cateName":"餐椅","cateImg":null,"cateId":2110,"cateImage":"","classify_rank":3},{"cateName":"婴儿推车","cateImg":null,"cateId":2111,"cateImage":"","classify_rank":3},{"cateName":"电动车","cateImg":null,"cateId":2112,"cateImage":"","classify_rank":3},{"cateName":"自行车","cateImg":null,"cateId":2113,"cateImage":"","classify_rank":3},{"cateName":"安全座椅","cateImg":null,"cateId":2114,"cateImage":"","classify_rank":3},{"cateName":"婴儿床垫","cateImg":null,"cateId":2115,"cateImage":"","classify_rank":3},{"cateName":"三轮车","cateImg":null,"cateId":2116,"cateImage":"","classify_rank":3},{"cateName":"扭扭车","cateImg":null,"cateId":2117,"cateImage":"","classify_rank":3},{"cateName":"民族乐器","cateImg":null,"cateId":2119,"cateImage":"","classify_rank":3},{"cateName":"吉他/尤克里里","cateImg":null,"cateId":2120,"cateImage":"","classify_rank":3},{"cateName":"电子琴/电钢琴","cateImg":null,"cateId":2121,"cateImage":"","classify_rank":3},{"cateName":"西洋管弦","cateImg":null,"cateId":2122,"cateImage":"","classify_rank":3},{"cateName":"钢琴","cateImg":null,"cateId":2123,"cateImage":"","classify_rank":3},{"cateName":"打击乐器","cateImg":null,"cateId":2124,"cateImage":"","classify_rank":3},{"cateName":"乐器配件","cateImg":null,"cateId":2125,"cateImage":"","classify_rank":3},{"cateName":"钙铁锌/维生素","cateImg":null,"cateId":2127,"cateImage":"","classify_rank":3},{"cateName":"面条/粥","cateImg":null,"cateId":2128,"cateImage":"","classify_rank":3},{"cateName":"DHA","cateImg":null,"cateId":2129,"cateImage":"","classify_rank":3},{"cateName":"宝宝零食","cateImg":null,"cateId":2130,"cateImage":"","classify_rank":3},{"cateName":"益生菌/初乳","cateImg":null,"cateId":2131,"cateImage":"","classify_rank":3},{"cateName":"米粉/菜粉","cateImg":null,"cateId":2132,"cateImage":"","classify_rank":3},{"cateName":"果泥/果汁","cateImg":null,"cateId":2133,"cateImage":"","classify_rank":3},{"cateName":"孕妈装","cateImg":null,"cateId":2135,"cateImage":"","classify_rank":3},{"cateName":"防溢乳垫","cateImg":null,"cateId":2136,"cateImage":"","classify_rank":3},{"cateName":"妈咪包/背婴带","cateImg":null,"cateId":2137,"cateImage":"","classify_rank":3},{"cateName":"文胸/内裤","cateImg":null,"cateId":2138,"cateImage":"","classify_rank":3},{"cateName":"防辐射服","cateImg":null,"cateId":2139,"cateImage":"","classify_rank":3},{"cateName":"产后塑身","cateImg":null,"cateId":2140,"cateImage":"","classify_rank":3},{"cateName":"孕妇护肤","cateImg":null,"cateId":2141,"cateImage":"","classify_rank":3},{"cateName":"孕期营养","cateImg":null,"cateId":2142,"cateImage":"","classify_rank":3},{"cateName":"待产护理","cateImg":null,"cateId":2143,"cateImage":"","classify_rank":3},{"cateName":"驱蚊防晒","cateImg":null,"cateId":2145,"cateImage":"","classify_rank":3},{"cateName":"洗发沐浴","cateImg":null,"cateId":2146,"cateImage":"","classify_rank":3},{"cateName":"坐便器","cateImg":null,"cateId":2148,"cateImage":"","classify_rank":3},{"cateName":"洗衣液/皂","cateImg":null,"cateId":2149,"cateImage":"","classify_rank":3},{"cateName":"日常护理","cateImg":null,"cateId":2150,"cateImage":"","classify_rank":3},{"cateName":"洗澡用具","cateImg":null,"cateId":2151,"cateImage":"","classify_rank":3},{"cateName":"婴儿口腔清洁","cateImg":null,"cateId":2152,"cateImage":"","classify_rank":3},{"cateName":"宝宝护肤","cateImg":null,"cateId":2153,"cateImage":"","classify_rank":3},{"cateName":"1段","cateImg":null,"cateId":2155,"cateImage":"","classify_rank":3},{"cateName":"2段","cateImg":null,"cateId":2156,"cateImage":"","classify_rank":3},{"cateName":"3段","cateImg":null,"cateId":2157,"cateImage":"","classify_rank":3},{"cateName":"4段","cateImg":null,"cateId":2158,"cateImage":"","classify_rank":3},{"cateName":"有机奶粉","cateImg":null,"cateId":2159,"cateImage":"","classify_rank":3},{"cateName":"特殊配方奶粉","cateImg":null,"cateId":2160,"cateImage":"","classify_rank":3},{"cateName":"孕妈奶粉","cateImg":null,"cateId":2161,"cateImage":"","classify_rank":3},{"cateName":"创意减压","cateImg":null,"cateId":2163,"cateImage":"","classify_rank":3},{"cateName":"健身玩具","cateImg":null,"cateId":2164,"cateImage":"","classify_rank":3},{"cateName":"动漫玩具","cateImg":null,"cateId":2165,"cateImage":"","classify_rank":3},{"cateName":"遥控/电动","cateImg":null,"cateId":2166,"cateImage":"","classify_rank":3},{"cateName":"DIY玩具","cateImg":null,"cateId":2167,"cateImage":"","classify_rank":3},{"cateName":"模型玩具","cateImg":null,"cateId":2168,"cateImage":"","classify_rank":3},{"cateName":"积木拼插","cateImg":null,"cateId":2169,"cateImage":"","classify_rank":3},{"cateName":"娃娃玩具","cateImg":null,"cateId":2170,"cateImage":"","classify_rank":3},{"cateName":"毛绒布艺","cateImg":null,"cateId":2171,"cateImage":"","classify_rank":3},{"cateName":"益智玩具","cateImg":null,"cateId":2172,"cateImage":"","classify_rank":3},{"cateName":"辅食料理机","cateImg":null,"cateId":2174,"cateImage":"","classify_rank":3},{"cateName":"儿童餐具","cateImg":null,"cateId":2175,"cateImage":"","classify_rank":3},{"cateName":"食物存储","cateImg":null,"cateId":2176,"cateImage":"","classify_rank":3},{"cateName":"暖奶消毒","cateImg":null,"cateId":2177,"cateImage":"","classify_rank":3},{"cateName":"吸奶器","cateImg":null,"cateId":2178,"cateImage":"","classify_rank":3},{"cateName":"围兜/防溅衣","cateImg":null,"cateId":2179,"cateImage":"","classify_rank":3},{"cateName":"奶瓶奶嘴","cateImg":null,"cateId":2180,"cateImage":"","classify_rank":3},{"cateName":"牙胶安抚","cateImg":null,"cateId":2181,"cateImage":"","classify_rank":3},{"cateName":"水壶/水杯","cateImg":null,"cateId":2182,"cateImage":"","classify_rank":3},{"cateName":"婴儿鞋帽袜","cateImg":null,"cateId":2184,"cateImage":"","classify_rank":3},{"cateName":"爬行垫","cateImg":null,"cateId":2185,"cateImage":"","classify_rank":3},{"cateName":"睡袋/抱被","cateImg":null,"cateId":2186,"cateImage":"","classify_rank":3},{"cateName":"婴儿礼盒","cateImg":null,"cateId":2187,"cateImage":"","classify_rank":3},{"cateName":"安全防护","cateImg":null,"cateId":2188,"cateImage":"","classify_rank":3},{"cateName":"婴儿外出服","cateImg":null,"cateId":2189,"cateImage":"","classify_rank":3},{"cateName":"家居床品","cateImg":null,"cateId":2190,"cateImage":"","classify_rank":3},{"cateName":"婴儿内衣","cateImg":null,"cateId":2191,"cateImage":"","classify_rank":3},{"cateName":"电热毯","cateImg":null,"cateId":2287,"cateImage":"","classify_rank":3},{"cateName":"床垫/床褥","cateImg":null,"cateId":2288,"cateImage":"","classify_rank":3},{"cateName":"理发器","cateImg":null,"cateId":2448,"cateImage":"","classify_rank":3}]},{"cateName":"个护美妆","cateImg":"http://www.svgouwu.com//data/cate_image/15034665358656.jpg","cateId":3673,"cateImage":"","classify_rank":2,"children":[]},{"cateName":"服饰箱包","cateImg":"http://www.svgouwu.com//data/cate_image/15034665476971.jpg","cateId":3674,"cateImage":"","classify_rank":2,"children":[]},{"cateName":"卫生保健","cateImg":"http://www.svgouwu.com//data/cate_image/15034665659752.jpg","cateId":3675,"cateImage":"","classify_rank":2,"children":[{"cateName":"耳鼻喉用药","cateImg":null,"cateId":2658,"cateImage":"","classify_rank":3},{"cateName":"肝胆用药","cateImg":null,"cateId":2659,"cateImage":"","classify_rank":3},{"cateName":"止痛镇痛","cateImg":null,"cateId":2660,"cateImage":"","classify_rank":3},{"cateName":"心脑血管","cateImg":null,"cateId":2661,"cateImage":"","classify_rank":3},{"cateName":"补气养血","cateImg":null,"cateId":2662,"cateImage":"","classify_rank":3},{"cateName":"儿科用药","cateImg":null,"cateId":2663,"cateImage":"","classify_rank":3},{"cateName":"补肾壮阳","cateImg":null,"cateId":2664,"cateImage":"","classify_rank":3},{"cateName":"妇科用药","cateImg":null,"cateId":2665,"cateImage":"","classify_rank":3},{"cateName":"感冒咳嗽","cateImg":null,"cateId":2666,"cateImage":"","classify_rank":3},{"cateName":"男科/泌尿","cateImg":null,"cateId":2667,"cateImage":"","classify_rank":3},{"cateName":"风湿骨外伤","cateImg":null,"cateId":2668,"cateImage":"","classify_rank":3},{"cateName":"胃肠消化","cateImg":null,"cateId":2669,"cateImage":"","classify_rank":3},{"cateName":"皮肤用药","cateImg":null,"cateId":2670,"cateImage":"","classify_rank":3},{"cateName":"口腔用药","cateImg":null,"cateId":2671,"cateImage":"","classify_rank":3},{"cateName":"眼科用药","cateImg":null,"cateId":2672,"cateImage":"","classify_rank":3},{"cateName":"隐形眼镜","cateImg":null,"cateId":2674,"cateImage":"","classify_rank":3},{"cateName":"美体护理","cateImg":null,"cateId":2675,"cateImage":"","classify_rank":3},{"cateName":"眼部保健","cateImg":null,"cateId":2676,"cateImage":"","classify_rank":3},{"cateName":"鼻喉护理","cateImg":null,"cateId":2677,"cateImage":"","classify_rank":3},{"cateName":"暖贴","cateImg":null,"cateId":2678,"cateImage":"","classify_rank":3},{"cateName":"跌打损伤","cateImg":null,"cateId":2679,"cateImage":"","classify_rank":3},{"cateName":"眼罩/耳塞","cateImg":null,"cateId":2680,"cateImage":"","classify_rank":3},{"cateName":"口罩","cateImg":null,"cateId":2681,"cateImage":"","classify_rank":3},{"cateName":"护理液","cateImg":null,"cateId":2682,"cateImage":"","classify_rank":3}]}]
         */

        private String cateName;
        private String cateImg;
        private int cateId;
        private String cateImage;
        private int classify_rank;
        private List<?> brand;
        private List<ChildrenBeanX> children;

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getCateImg() {
            return cateImg;
        }

        public void setCateImg(String cateImg) {
            this.cateImg = cateImg;
        }

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getCateImage() {
            return cateImage;
        }

        public void setCateImage(String cateImage) {
            this.cateImage = cateImage;
        }

        public int getClassify_rank() {
            return classify_rank;
        }

        public void setClassify_rank(int classify_rank) {
            this.classify_rank = classify_rank;
        }

        public List<?> getBrand() {
            return brand;
        }

        public void setBrand(List<?> brand) {
            this.brand = brand;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * cateName : 母婴用品
             * cateImg : http://www.svgouwu.com//data/cate_image/15034664414782.jpg
             * cateId : 3648
             * cateImage :
             * classify_rank : 2
             * children : [{"cateName":"纸尿裤","cateImg":null,"cateId":2103,"cateImage":"","classify_rank":3},{"cateName":"成人尿裤","cateImg":null,"cateId":2104,"cateImage":"","classify_rank":3},{"cateName":"拉拉裤","cateImg":null,"cateId":2105,"cateImage":"","classify_rank":3},{"cateName":"婴儿床","cateImg":null,"cateId":2107,"cateImage":"","classify_rank":3},{"cateName":"学步车","cateImg":null,"cateId":2108,"cateImage":"","classify_rank":3},{"cateName":"滑板车","cateImg":null,"cateId":2109,"cateImage":"","classify_rank":3},{"cateName":"餐椅","cateImg":null,"cateId":2110,"cateImage":"","classify_rank":3},{"cateName":"婴儿推车","cateImg":null,"cateId":2111,"cateImage":"","classify_rank":3},{"cateName":"电动车","cateImg":null,"cateId":2112,"cateImage":"","classify_rank":3},{"cateName":"自行车","cateImg":null,"cateId":2113,"cateImage":"","classify_rank":3},{"cateName":"安全座椅","cateImg":null,"cateId":2114,"cateImage":"","classify_rank":3},{"cateName":"婴儿床垫","cateImg":null,"cateId":2115,"cateImage":"","classify_rank":3},{"cateName":"三轮车","cateImg":null,"cateId":2116,"cateImage":"","classify_rank":3},{"cateName":"扭扭车","cateImg":null,"cateId":2117,"cateImage":"","classify_rank":3},{"cateName":"民族乐器","cateImg":null,"cateId":2119,"cateImage":"","classify_rank":3},{"cateName":"吉他/尤克里里","cateImg":null,"cateId":2120,"cateImage":"","classify_rank":3},{"cateName":"电子琴/电钢琴","cateImg":null,"cateId":2121,"cateImage":"","classify_rank":3},{"cateName":"西洋管弦","cateImg":null,"cateId":2122,"cateImage":"","classify_rank":3},{"cateName":"钢琴","cateImg":null,"cateId":2123,"cateImage":"","classify_rank":3},{"cateName":"打击乐器","cateImg":null,"cateId":2124,"cateImage":"","classify_rank":3},{"cateName":"乐器配件","cateImg":null,"cateId":2125,"cateImage":"","classify_rank":3},{"cateName":"钙铁锌/维生素","cateImg":null,"cateId":2127,"cateImage":"","classify_rank":3},{"cateName":"面条/粥","cateImg":null,"cateId":2128,"cateImage":"","classify_rank":3},{"cateName":"DHA","cateImg":null,"cateId":2129,"cateImage":"","classify_rank":3},{"cateName":"宝宝零食","cateImg":null,"cateId":2130,"cateImage":"","classify_rank":3},{"cateName":"益生菌/初乳","cateImg":null,"cateId":2131,"cateImage":"","classify_rank":3},{"cateName":"米粉/菜粉","cateImg":null,"cateId":2132,"cateImage":"","classify_rank":3},{"cateName":"果泥/果汁","cateImg":null,"cateId":2133,"cateImage":"","classify_rank":3},{"cateName":"孕妈装","cateImg":null,"cateId":2135,"cateImage":"","classify_rank":3},{"cateName":"防溢乳垫","cateImg":null,"cateId":2136,"cateImage":"","classify_rank":3},{"cateName":"妈咪包/背婴带","cateImg":null,"cateId":2137,"cateImage":"","classify_rank":3},{"cateName":"文胸/内裤","cateImg":null,"cateId":2138,"cateImage":"","classify_rank":3},{"cateName":"防辐射服","cateImg":null,"cateId":2139,"cateImage":"","classify_rank":3},{"cateName":"产后塑身","cateImg":null,"cateId":2140,"cateImage":"","classify_rank":3},{"cateName":"孕妇护肤","cateImg":null,"cateId":2141,"cateImage":"","classify_rank":3},{"cateName":"孕期营养","cateImg":null,"cateId":2142,"cateImage":"","classify_rank":3},{"cateName":"待产护理","cateImg":null,"cateId":2143,"cateImage":"","classify_rank":3},{"cateName":"驱蚊防晒","cateImg":null,"cateId":2145,"cateImage":"","classify_rank":3},{"cateName":"洗发沐浴","cateImg":null,"cateId":2146,"cateImage":"","classify_rank":3},{"cateName":"坐便器","cateImg":null,"cateId":2148,"cateImage":"","classify_rank":3},{"cateName":"洗衣液/皂","cateImg":null,"cateId":2149,"cateImage":"","classify_rank":3},{"cateName":"日常护理","cateImg":null,"cateId":2150,"cateImage":"","classify_rank":3},{"cateName":"洗澡用具","cateImg":null,"cateId":2151,"cateImage":"","classify_rank":3},{"cateName":"婴儿口腔清洁","cateImg":null,"cateId":2152,"cateImage":"","classify_rank":3},{"cateName":"宝宝护肤","cateImg":null,"cateId":2153,"cateImage":"","classify_rank":3},{"cateName":"1段","cateImg":null,"cateId":2155,"cateImage":"","classify_rank":3},{"cateName":"2段","cateImg":null,"cateId":2156,"cateImage":"","classify_rank":3},{"cateName":"3段","cateImg":null,"cateId":2157,"cateImage":"","classify_rank":3},{"cateName":"4段","cateImg":null,"cateId":2158,"cateImage":"","classify_rank":3},{"cateName":"有机奶粉","cateImg":null,"cateId":2159,"cateImage":"","classify_rank":3},{"cateName":"特殊配方奶粉","cateImg":null,"cateId":2160,"cateImage":"","classify_rank":3},{"cateName":"孕妈奶粉","cateImg":null,"cateId":2161,"cateImage":"","classify_rank":3},{"cateName":"创意减压","cateImg":null,"cateId":2163,"cateImage":"","classify_rank":3},{"cateName":"健身玩具","cateImg":null,"cateId":2164,"cateImage":"","classify_rank":3},{"cateName":"动漫玩具","cateImg":null,"cateId":2165,"cateImage":"","classify_rank":3},{"cateName":"遥控/电动","cateImg":null,"cateId":2166,"cateImage":"","classify_rank":3},{"cateName":"DIY玩具","cateImg":null,"cateId":2167,"cateImage":"","classify_rank":3},{"cateName":"模型玩具","cateImg":null,"cateId":2168,"cateImage":"","classify_rank":3},{"cateName":"积木拼插","cateImg":null,"cateId":2169,"cateImage":"","classify_rank":3},{"cateName":"娃娃玩具","cateImg":null,"cateId":2170,"cateImage":"","classify_rank":3},{"cateName":"毛绒布艺","cateImg":null,"cateId":2171,"cateImage":"","classify_rank":3},{"cateName":"益智玩具","cateImg":null,"cateId":2172,"cateImage":"","classify_rank":3},{"cateName":"辅食料理机","cateImg":null,"cateId":2174,"cateImage":"","classify_rank":3},{"cateName":"儿童餐具","cateImg":null,"cateId":2175,"cateImage":"","classify_rank":3},{"cateName":"食物存储","cateImg":null,"cateId":2176,"cateImage":"","classify_rank":3},{"cateName":"暖奶消毒","cateImg":null,"cateId":2177,"cateImage":"","classify_rank":3},{"cateName":"吸奶器","cateImg":null,"cateId":2178,"cateImage":"","classify_rank":3},{"cateName":"围兜/防溅衣","cateImg":null,"cateId":2179,"cateImage":"","classify_rank":3},{"cateName":"奶瓶奶嘴","cateImg":null,"cateId":2180,"cateImage":"","classify_rank":3},{"cateName":"牙胶安抚","cateImg":null,"cateId":2181,"cateImage":"","classify_rank":3},{"cateName":"水壶/水杯","cateImg":null,"cateId":2182,"cateImage":"","classify_rank":3},{"cateName":"婴儿鞋帽袜","cateImg":null,"cateId":2184,"cateImage":"","classify_rank":3},{"cateName":"爬行垫","cateImg":null,"cateId":2185,"cateImage":"","classify_rank":3},{"cateName":"睡袋/抱被","cateImg":null,"cateId":2186,"cateImage":"","classify_rank":3},{"cateName":"婴儿礼盒","cateImg":null,"cateId":2187,"cateImage":"","classify_rank":3},{"cateName":"安全防护","cateImg":null,"cateId":2188,"cateImage":"","classify_rank":3},{"cateName":"婴儿外出服","cateImg":null,"cateId":2189,"cateImage":"","classify_rank":3},{"cateName":"家居床品","cateImg":null,"cateId":2190,"cateImage":"","classify_rank":3},{"cateName":"婴儿内衣","cateImg":null,"cateId":2191,"cateImage":"","classify_rank":3},{"cateName":"电热毯","cateImg":null,"cateId":2287,"cateImage":"","classify_rank":3},{"cateName":"床垫/床褥","cateImg":null,"cateId":2288,"cateImage":"","classify_rank":3},{"cateName":"理发器","cateImg":null,"cateId":2448,"cateImage":"","classify_rank":3}]
             */

            private String cateName;
            private String cateImg;
            private int cateId;
            private String cateImage;
            private int classify_rank;
            private List<ChildrenBean> children;

            public String getCateName() {
                return cateName;
            }

            public void setCateName(String cateName) {
                this.cateName = cateName;
            }

            public String getCateImg() {
                return cateImg;
            }

            public void setCateImg(String cateImg) {
                this.cateImg = cateImg;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public String getCateImage() {
                return cateImage;
            }

            public void setCateImage(String cateImage) {
                this.cateImage = cateImage;
            }

            public int getClassify_rank() {
                return classify_rank;
            }

            public void setClassify_rank(int classify_rank) {
                this.classify_rank = classify_rank;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * cateName : 纸尿裤
                 * cateImg : null
                 * cateId : 2103
                 * cateImage :
                 * classify_rank : 3
                 */

                private String cateName;
                private Object cateImg;
                private int cateId;
                private String cateImage;
                private int classify_rank;

                public String getCateName() {
                    return cateName;
                }

                public void setCateName(String cateName) {
                    this.cateName = cateName;
                }

                public Object getCateImg() {
                    return cateImg;
                }

                public void setCateImg(Object cateImg) {
                    this.cateImg = cateImg;
                }

                public int getCateId() {
                    return cateId;
                }

                public void setCateId(int cateId) {
                    this.cateId = cateId;
                }

                public String getCateImage() {
                    return cateImage;
                }

                public void setCateImage(String cateImage) {
                    this.cateImage = cateImage;
                }

                public int getClassify_rank() {
                    return classify_rank;
                }

                public void setClassify_rank(int classify_rank) {
                    this.classify_rank = classify_rank;
                }
            }
        }
}
