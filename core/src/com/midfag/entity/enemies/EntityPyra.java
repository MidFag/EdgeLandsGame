package com.midfag.entity.enemies;




import com.badlogic.gdx.math.Vector2;
import com.midfag.entity.Entity;


import com.midfag.equip.weapon.*;


import com.midfag.game.Assets;
import com.midfag.game.GScreen;

import com.midfag.game.Main;


public class EntityPyra extends Entity {
	
	//Sprite spr=new Sprite(new Texture(Gdx.files.internal("barrel.png")));
	

	private float rotate_cooldown;
	private float body_rotate_cooldown;
	//private int body_rotate;
	
	public EntityPyra(Vector2 _v,boolean _custom)
	{
		super (_v, _custom);
		
		spr.setTexture(Assets.pyra_body[0]);
		pos=_v;
		
		custom_phys=_custom;
		
		id="pyra";
		
		armored[0]=new WeaponRobofirle();
		armored[0].generate();
		armored[1]=null;
		
		if (armored[0]!=null)
		{
			armored[0].cd=(float) (Math.random()*1);
			armored[0].ammo=(int) armored[0].total_ammo_size;
		}
		
		if (armored[1]!=null)
		{
			armored[1].cd=(float) (Math.random()*1);
			armored[1].ammo=(int) armored[1].total_ammo_size;
		}	
		
		spr.setOrigin(50, 0);
		offset.y=50;
		can_rotate=false;
		
		friction=0.5f;
		speed/=1.5f;
	}
	
	@Override
	public void draw_action(float _d) {

		if (rotate_cooldown<=0)
		{
			rotate_cooldown=0.1f;
			
			float a=GScreen.pl.pos.x-pos.x;
	    	float b=GScreen.pl.pos.y-pos.y;
	    	//float c=(float) Math.sqrt((a*a)+(b*b));
	    	float c=(float) Math.toDegrees(Math.atan2(a, b));
	    	//spr.setRotation(180-c);
	    	
	    	rot=180-c+180;
			
				//if ((impulse.x>0)&&(bottom_draw>=0)&&(bottom_draw<=3)){bottom_draw++;}
				if (c<0){c=360+c;}
		    	
		    	if (c>360){c=c-360;}
		    	//pl.spr.setRotation(360-c);
		    	if (c>347)
				{bottom_draw=0;}
		    	else
		    	{bottom_draw=(int) Math.round(c/22.5);}
			
			
			
		}
		else
		{
			rotate_cooldown-=_d;
		}
		
		if (body_rotate_cooldown<=0)
		{
			draw_sprite+=1;
			if (draw_sprite>15) {draw_sprite=0;}
			
			body_rotate_cooldown=0.2f;
		}
		else
		{
			body_rotate_cooldown-=_d;
		}
		spr.translate(-25,-80);
		spr.setSize(100, 200);
		spr.setTexture(Assets.shadow);
		spr.draw(Main.batch);
		spr.translate(25,80);
		
		spr.setSize(100, 100);
		
		spr.setTexture(Assets.pyra_body[draw_sprite]);
		spr.draw(Main.batch);
		
		spr.translateY(-10);
		spr.setTexture(Assets.pyra_head[bottom_draw]);
		spr.draw(Main.batch);
		spr.translateY(10);
		
		

	}
	

	
	
	
	
}
