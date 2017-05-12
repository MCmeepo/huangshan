package com.meepo.huangshan.UI.CardAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L18Card;
import com.meepo.huangshan.bean.L18CardArmsCard;
import com.meepo.huangshan.bean.L18CardAttackspellCardSpellCard;
import com.meepo.huangshan.bean.L18CardEffectspellCard;
import com.meepo.huangshan.bean.L18cardMinionCard;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<L18Card> mData;

    public CardAdapter(Context context, ArrayList<L18Card> mdata) {
        mContext = context;
        mData = mdata;
    }


    @Override
    public int getCount() {
        return mData.size(); //size   arraylist的对象个数
    }

    @Override
    public L18Card getItem(int position) {    //获取arraylist中的数据对象
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {   //获取arraylist中的数据对象的id
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {    //获取某一项的子视图
        LayoutInflater inflater = LayoutInflater.from(mContext); //在布局填充器中，填入mContext
        Holder holder; //建立一个holder，声明控件

        if (view == null) {
            // 该类型的布局第一次出现在界面上
            view = inflater.inflate(R.layout.adapter_card, viewGroup, false);
            holder = new Holder();
            holder.mIvIcon = (ImageView) view.findViewById(R.id.l20_miv);
            holder.mTvName = (TextView) view.findViewById(R.id.l20_name);
            holder.mTvAttack = (TextView) view.findViewById(R.id.l20_damage);
            holder.mTvCost = (TextView) view.findViewById(R.id.l20_mcost);
            holder.mTvother = (TextView) view.findViewById(R.id.l20_other);
            holder.mTveffect = (TextView) view.findViewById(R.id.l20_effect);
            // 把填好控件的 holder 放入控件的 tag 中
            view.setTag(holder);
        } else {
            // 从控件的 tag 中加载 holder
            holder = (Holder) view.getTag();
        }

        // 通过索引从数据集合中获取数据对象
        L18Card card = mData.get(position);
        holder.mTvName.setText(card.getName());
        holder.mTvCost.setText("水晶：" + card.getCost());
        // instanceof:a instance of b         a是b一个实例
        if (card instanceof L18CardAttackspellCardSpellCard) {
            L18CardAttackspellCardSpellCard ACS = (L18CardAttackspellCardSpellCard) card;
            holder.mTvAttack.setText("伤害：" + ACS.getDamage());     //吧card强转成攻击法术牌acs
            holder.mIvIcon.setImageResource(R.mipmap.gongjifashu);
            holder.mTveffect.setText("");
            holder.mTvother.setText("");
        } else if (card instanceof L18cardMinionCard) {
            L18cardMinionCard minion = (L18cardMinionCard) card;
            holder.mTvAttack.setText("攻击力：" + minion.getDamage());
            holder.mTvother.setText("体力：" + minion.getBlood());
            holder.mIvIcon.setImageResource(R.mipmap.suicong);
            holder.mTveffect.setText("");
        } else if (card instanceof L18CardEffectspellCard) {
            L18CardEffectspellCard ES = (L18CardEffectspellCard) card;
            holder.mTveffect.setText("技能效果：" + ES.getEffect());
            holder.mIvIcon.setImageResource(R.mipmap.xiaoguo);
            holder.mTvAttack.setText("");
            holder.mTvother.setText("");
        } else if (card instanceof L18CardArmsCard) {
            L18CardArmsCard a = (L18CardArmsCard) card;
            holder.mTvAttack.setText("伤害：" + a.getDamage());
            holder.mTvother.setText("耐久度：" + a.getDurable());
            holder.mIvIcon.setImageResource(R.mipmap.wuqi);
            holder.mTveffect.setText("");
        } else {
            // 没用到的控件必须清空数据
            holder.mTvAttack.setText("");
            holder.mTvother.setText("");
            holder.mTveffect.setText("");
        }
        return view;
    }

    private class Holder {
        ImageView mIvIcon;
        TextView mTvName;
        TextView mTvCost;
        TextView mTvAttack;
        TextView mTvother;
        TextView mTveffect;
    }
}
