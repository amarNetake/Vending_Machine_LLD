package entities;

public class Item {
	private final String itemId;
	private final String title;
	private int cost;
	
	public Item(Builder builder) {
		this.itemId = builder.itemId;
		this.title = builder.title;
		this.cost = builder.cost;
	}

	public static class Builder{
		public String itemId = java.util.UUID.randomUUID().toString();
		public final String title;
		public int cost;
		
		public Builder(String title) {
			this.title = title;
		}
		
		public Builder itemId(String itemId) {
			this.itemId = itemId;
			return this;
		}
		
		public Builder cost(int cost) {
			this.cost = cost;
			return this;
		}
		
		public Item build() {
			return new Item(this);
		}
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getItemId() {
		return itemId;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", title=" + title + ", cost=" + cost + "]";
	}
	
	
	
}
