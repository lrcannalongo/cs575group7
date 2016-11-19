package dragonbids.api;

import java.time.LocalDateTime;

public class ListingSkeleton{
	int listingId;
	String sellerUsername;
	String buyerUsername;
	String auctionTile;
	String auctionDescription;
	LocalDateTime auctionCompletionDateTime;
	int extendAuctionMinutes;
	long currentPrice;
	long proposedPrice;
	
	public ListingSkeleton()
	{
		listingId = -1;
		sellerUsername = "";
		buyerUsername = "";
		auctionTile = "";
		auctionDescription = "";
		extendAuctionMinutes = -1;
		currentPrice = -1;
		proposedPrice = -1;
		auctionCompletionDateTime = null;
	}
}
