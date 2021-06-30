package com.cognizant.truyum.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;
	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}
	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItem();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart();
			cart.getMenuItem().add(menuItem);
			userCarts.put(userId, cart);
		}
	}
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItem();
			if (menuItemList.isEmpty()) {
				throw (new CartEmptyException());
			} else {
				double total = 0.0;
				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			return menuItemList;
		} else {
			throw (new CartEmptyException());
		}
	}
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItem();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
	}
}