package com.midfag.entity.decorations;


import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;
import com.midfag.game.Assets;
import com.midfag.game.GScreen;
import com.midfag.game.Phys;

public class DecorStonePilon extends DecorStoneWall {

	public DecorStonePilon(Vector2 _v) {
		
		super(_v);


		custom_phys=true;
		
		spr.setTexture(Assets.stone_pilon_01);
		icon=Assets.decoration_stone_pilon_icon;
		id=this.getClass().getName();
		
		diagonal=false;
		
		spr.setSize(30, 84);
		spr.setOrigin(16f, 0f);
		
		path=true;
		//spr.setOrigin(80.0f, 10f);
		
		//shield=999999;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Entity put() {
		// TODO Auto-generated method stub
		return new DecorStonePilon(new Vector2());
	}
	
	@Override
	public void do_custom_phys()
	{
		int x=(int)(pos.x/300);
		int y=(int)(pos.y/300);
		
		
		Phys p=new Phys(new Vector2(pos.x-28,pos.y-28),new Vector2(pos.x+28,pos.y-28),true,this,true);
		GScreen.cluster[x][y].Phys_list.add(p);
		Phys_list_local.add(p);
		
		p=new Phys(new Vector2(pos.x+28,pos.y-28),new Vector2(pos.x+28,pos.y+28),true,this,true);
		GScreen.cluster[x][y].Phys_list.add(p);
		Phys_list_local.add(p);
		
		p=new Phys(new Vector2(pos.x+28,pos.y+28),new Vector2(pos.x-28,pos.y+28),true,this,true);
		GScreen.cluster[x][y].Phys_list.add(p);
		Phys_list_local.add(p);
		
		p=new Phys(new Vector2(pos.x-28,pos.y+28),new Vector2(pos.x-28,pos.y-28),true,this,true);
		GScreen.cluster[x][y].Phys_list.add(p);
		Phys_list_local.add(p);
		
	}
	

	

}
