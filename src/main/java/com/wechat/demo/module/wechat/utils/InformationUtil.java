package com.wechat.demo.module.wechat.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.wechat.service.CoreSevice;

/**
 * 处理消息
 */
public class InformationUtil {

    //获取要群发的图文消息
    public static String uploadMaterial(){
        JSONObject resultJson = new JSONObject();
        JSONArray arrtArray = new JSONArray();
        JSONObject msg = null;
        String[] mediaId = {
                "OoZPMRjG7qN9iMtu33ennJJu-B-0pKFlBpfuL5P1QlCIw03ejyP-clwVUiGfzlii",
                "q6Zf7HaZHyzQRTrwuHcth45pIzNYRCjiqEXv7LiwxH1Qzl_YefZYJyFpgt28iSdr",
                "CgQNbR58MkgF-yo76kN88mhuto1HOc4urexhjhTdqUkf3X06ctvQDNMLxf1o2adh"};
        String[] title = {"熊猫人周卓---垃圾","鸣人","伊利丹.怒风-彻底摧毁燃烧军团"};
        String[] digest = {
                "炉石传说：盘点炉石传说中神秘的熊猫人一族 数量最少出橙率最高",
                "漩涡鸣人，日本漫画《火影忍者》及其衍生作品中的男主角。",
                "伊利丹·怒风曾因不择手段追求力量而被误解成背叛者，但他的目标却从未改变：彻底摧毁燃烧军团。"
        };
        String[] content = {
                "<p>炉石的小伙伴你们好啊！我是每天分享炉石趣闻的小岚 玩炉石的小伙伴都知道 炉石传说中的卡牌里面除了法术牌、武器牌外就是各种各样的随从卡牌了，而炉石里面的随从也是很多都有自己独特的种族像广大的‘鱼人’群众、术士职业专属的‘恶魔’、猎人的好伙伴‘野兽’还有力量强大的‘龙’、受萨满召唤的‘图腾’、天生与法师亲和的‘元素’、曾经辉煌一时的‘海盗’和地精制造的‘机械’但要说炉石传说里面最神秘的‘种族’还得属于‘熊猫人’，‘熊猫人’在炉石传说里面可以说是种族最少的随从但是出现的橙卡却不少。" +
                        "2费0-4的周卓光环效果：每当玩家施放法术后将改法术置于另一玩家的手牌中。因为其独特的逗比光环和白板身材让周卓难以进入构筑卡组但却时常活跃在好友对战的战场上，常常能做到好友双方互换buff突破伤害上限然后被强制掉线。所以周卓又称‘炸服者’。但是在最早版本的周卓绝对是一张强度爆炸的橙卡，曾经的周卓1费1-4的身材光环效果不变，但是身材绝对超模。不管是先手还是后手都能让对手脑壳痛，最重要的是那个时候的周卓还能主动送掉不像现在白板身材想要自己戒掉就的给对面送法术" +
                        "大小熊猫的战吼效果完全一样区别在于身材上的不同，战吼效果：使一个友方随从从战场上移回你的手牌。在狗头人版本里的‘蛇发女妖’没有出现前，大小熊猫的战吼效果绝对是很超模的存在，可以配合一些战吼效果出众的随从回手在打出。</p>",
                "<p>漩涡鸣人，日本漫画《火影忍者》及其衍生作品中的男主角。火之国木叶隐村的忍者，四代目火影波风水门和漩涡玖辛奈之子，六道仙人次子阿修罗转世。刚出生时父母为保护村子而牺牲，并将尾兽“九尾”封印在鸣人体内。成为孤儿的鸣人从小被村民歧视，但在唯一认同他的老师海野伊鲁卡以及三代目火影猿飞日斩的鼓励下有了要成为火影的梦想，让所有人都认同他的存在。成为忍者后，和旗木卡卡西、宇智波佐助以及春野樱组成第七班进行各种任务。\n" +
                        "为实现梦想，和守护伙伴们的羁绊，鸣人不断修炼变强，作为木叶“三忍”之一自来也的弟子，在追求梦想的过程中不断突破自我，贯彻了自身的忍道，获得人们的认可。最后与忍者联军以及宇智波佐助还有九尾一同终结了战争，为忍者世界带来和平，并实现自己成为火影（七代目火影）和忍界英雄的梦想。 [1]漩涡鸣人（うずまきナルト）这个名字来自于日本一座名叫鸣门市（ナルト）的城市，此城临海，有机会的话还可以看到海面上的漩涡（鸣门涡潮），十分壮观。“ナルト”还有一个意思，就是日本拉面中放在面上的一种常见的装饰型食品“鸣门卷”（鸣门巻き，即鱼板），由于形状像鸣门市的涡潮而得名； [3] \n" +
                        "由于“うずまきナルト”在日文中存在同音词“涡巻”“鸣门”，因此“漩涡鸣人”在港澳地区被翻译为“涡卷鸣门”；\n" +
                        "在漫画中鸣人的名字则是出自自来也写的《坚毅忍传》主角的名字，因为其书中主人公拥有诸多美好向上的精神，故鸣人父母希望鸣人将来可以成为那样永不言弃的人；" +
                        "</p>",
                "<p>自从上古之战起，伊利丹·怒风就为了击败燃烧军团一直不断地努力着。他是抗击燃烧军团的暗夜精灵中的一员，但他采取的极端方式却与所有暗夜精灵都完全不同。坚定的决心驱使他离开了自己的族人，与军团立下了契约。通过这样的方式，他获得了更强大的力量，也了解了恶魔的弱点所在，但他也被暗夜精灵永远地视为族人的背叛者。击败了燃烧军团后，暗夜精灵将他关押起来，以防他再对这个饱受创伤的世界造成伤害。\n" +
                        "一万年后，伊利丹终于重获自由。但他并没有踏上赎罪之路，而是通过魔能变成了一只恶魔——一只奋力于摧毁燃烧军团的恶魔。他前往外域并组建了自己的军团：伊利达雷恶魔猎手。有了这些灌注了魔能的士兵，背叛者期望能一劳永逸地解决燃烧军团的威胁。但在他完成他的大业前，他就被联盟和部落的英雄们阻止了。他的尸体被运到了艾泽拉斯并安置在守望者地窟中。\n" +
                        "虽然伊利丹已经战死，但他的遗愿已被他的恶魔猎手们所继承。这些暗影战士有一部分与伊利丹的尸体一道被关押在守望者地窟，但也有很多仍不明去向。令人惧怕的是，可能这些恶魔猎手仍在某处继续着伊利丹与燃烧军团之间的宿命之战……而且不惜一切代价要取得胜利。</p>"
        };
        for (int i = 0 ; i < 3 ; i++ ){
            msg = new JSONObject();
            msg.put("thumb_media_id",mediaId[i]);//图文消息缩略图的media_id，可以在素材管理-新增素材中获得
            msg.put("author","小孙");//图文消息的作者
            msg.put("title",title[i]);//图文消息的标题
            //默认跳转百度
            msg.put("content_source_url","http://www.baidu.com");//在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
            msg.put("content",content[i]);//图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用
            msg.put("digest",digest[i]);//图文消息的描述，如本字段为空，则默认抓取正文前64个字
            msg.put("show_cover_pic",1);//是否显示封面，1为显示，0为不显示
            msg.put("need_open_comment",1);//Uint32 是否打开评论，0不打开，1打开
            msg.put("only_fans_can_comment",0);//Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
            arrtArray.add(msg);
        }
        resultJson.put("articles",arrtArray);
        System.err.println(resultJson);
        String data = HttpUtils.sendPostJson(resultJson, InvariableAttribute.UPLOADPAGSC + CoreSevice.getAccessToken());
        System.err.println(data);
        String id = JSONObject.parseObject(data).getString("media_id");
        return id;
    }

    public static void main(String[] args) {
        //
        JSONObject result = new JSONObject();
        JSONObject mpnews = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("oBehx5pUlKbYz7ObBrgQsARCo6xo");
        jsonArray.add("oBehx5q6d6RaB2AYPNkSuc-NkaMA");
        jsonArray.add("oBehx5jI56qS5SKGYF47HX8B2uec");
        mpnews.put("media_id","eAIUoXT0uwisx_ZQouIBrFb86RtQxq-27Gl4AINvsebYKa6HhKTktLSKKboW8xtY");//用于群发的消息的media_id
        result.put("mpnews",mpnews);//用于设定即将发送的图文消息
        result.put("msgtype","mpnews");//群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
//        result.put("send_ignore_reprint",0);//图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
        result.put("touser","oBehx5jI56qS5SKGYF47HX8B2uec");
        System.err.println(result);
        String data = HttpUtils.sendPostJson(result,InvariableAttribute.MASS_TEXTING + CoreSevice.getAccessToken());
        System.err.println(data);
    }

////{"tag":{"id":100,"name":"群发消息"}}
//    public static void main(String[] args) {
////        String s = "{   \"tag\" : {     \"name\" : \"群发消息\"   } } ";
////        String data = HttpUtils.sendPostJson(JSONObject.parseObject(s),"https://api.weixin.qq.com/cgi-bin/tags/create?access_token=" + CoreSevice.getAccessToken());
////        System.err.println(data);
//        String s = "{   \"tagid\" : 100,   \"next_openid\":\"\" } ";
//        String data = HttpUtils.sendPostJson(JSONObject.parseObject(s),"https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=" + CoreSevice.getAccessToken());
//        System.err.println(data);
//    }

//    public static void main(String[] args) {
//        /**
//         * {"type":"news","media_id":"eAIUoXT0uwisx_ZQouIBrFb86RtQxq-27Gl4AINvsebYKa6HhKTktLSKKboW8xtY","created_at":1575448579,"item":[]}
//         * eAIUoXT0uwisx_ZQouIBrFb86RtQxq-27Gl4AINvsebYKa6HhKTktLSKKboW8xtY
//         */
//        System.out.println(uploadMaterial());
//    }

}
