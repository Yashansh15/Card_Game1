# Card_Game1
Playing cards come as Full Pack of 52 cards. (4 Suits X 13 Ranks). Ref
the picture. 
# 4 Suits are CLUB, DIAMOND, HEART, SPADE (from smallest to highest
in value)
# Ranks are called as TWO, THREE, ..., TEN, JACK, QUEEN, KING, ACE
(from smallest to highest in value)
 Any group of cards (containing 1..52 cards) is called Pack of Cards.
 Full pack is a Pack of Cards initialized with all 52 cards, but in the
game as one or more cads are drawn from Full Pack, the count may go
down till zero.
 Pack of Cards will maintain the sequence unless changed by any act
like shuffle, reset etc.
 A Player can do following actions with Pack of Cards
o can shuffle
o can get top card
o can add a card (duplicates are not allowed)
o can get random card
o can query size of pack.
o Can reset sequence in ascending/ descending order.
 Game begins by initializing the Full pack. 
 Player (with name) registers with the game. 
 Once two players register for the Game (as a poker game), game will
automatically start. [hint: will call its play() method]
 When game is played (in a game.play()), three cards will be given to
each Player as one card at a time in alternate manner. Plyers add this
each card in their Cards in Hand.
 Once three cards are distributed, Each Player has Cards in Hand (as a
pack of 3 cards). Based on following rule, game will declare winner
player. (This being simple luck game, player does not take any action)
o Rule for winner.
 Each card has a value computed using following algorithm.
 Each suit has suit-weight associated as {SPADE(3),
HEART(2), DIAMOND(1), CLUB(0)}
 Each rank has rank-weight associated as {TWO(0),
THREE(1),.., JACK(9), QUEEN(10), KING(11),
ACE(12)}
 Value of the card is computed as Rank-weight * 4 +
Suit-weight. (e.g. CLUB-JACK will have value 9 * 4 +
0 = 36, SPADE-SIX will have weight 4*4 + 3 = 19)

 Highest card for player is card with highest value in “Cards
in Hand” for player.
 Each player’s highest card is Card with highest value.
 Game will compare highest cards for each player, and
player with higher “Highest Card” wins the game.
