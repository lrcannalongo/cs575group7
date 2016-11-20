package dragonbids.api;

import java.time.LocalDateTime;

public class ListingSkeleton{
	public int listingId;
	public String sellerUsername;
	public String buyerUsername;
	public String auctionTile;
	public String auctionDescription;
	public LocalDateTime auctionCompletionDateTime;
	public int extendAuctionMinutes;
	public long currentPrice;
	public long proposedPrice;
	
	public ListingSkeleton()
	{
		this.listingId = -1;
		this.sellerUsername = "";
		this.buyerUsername = "";
		this.auctionTile = "";
		this.auctionDescription = "";
		this.extendAuctionMinutes = -1;
		this.currentPrice = -1;
		this.proposedPrice = -1;
		this.auctionCompletionDateTime = null;
	}
}
