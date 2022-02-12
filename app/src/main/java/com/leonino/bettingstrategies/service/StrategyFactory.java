package com.leonino.bettingstrategies.service;

import android.content.Context;
import android.content.SharedPreferences;

import com.leonino.bettingstrategies.models.Strategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StrategyFactory {
    public static List<Strategy> getStrategies() {
        return List.of(
                new Strategy(
                        "1X on home outsiders strategy",
                        "A betting strategy that has been successful in the past is the " +
                                "bet on the “double chance” 1X if an outsider plays against a " +
                                "favorite at home. In this case, the “1X” bet brings respectable " +
                                "odds and very interesting profit opportunities."
                ),
                new Strategy(
                        "All-in on odds at 1.20 strategy",
                        "This betting strategy involves winning numerous bets one after" +
                                " the other and always using the maximum offers the opportunity to" +
                                " earn decent money. But it is also clear that all the money is " +
                                "gone if you lose a bet. But if you manage to win 30, 35, maybe " +
                                "even 40 times in a row, you’ll get big money!"
                ),
                new Strategy(
                        "The Fibonacci betting system",
                        "Fibonacci sequence betting is undoubtedly a controversial " +
                                "concept. But there are definitely sports bettors who were able " +
                                "to achieve great success with it. This strategy carries some " +
                                "risks, but with the necessary luck and the right nose, you can " +
                                "be successful while employing this strategy."
                ),
                new Strategy(
                        "The Kelly formula",
                        "There are of course numerous ideas, concepts and formulas that " +
                                "can help you calculate the ideal stake on a bet. One of them is " +
                                "the Kelly formula. Of course, this is no guarantee that you will " +
                                "always bet correctly and the assessment of how likely the outcome " +
                                "of a game is, does still remain up to you. But the Kelly formula " +
                                "can help you choose the size of your bet."
                ),
                new Strategy(
                        "Early cashout in sports betting",
                        "Have you ever regretted placing a particular bet and wished " +
                                "that you could somehow withdraw it? Or maybe you had doubts as " +
                                "to whether the team you supported could really hold the lead? " +
                                "If your answer to any of the questions is yes, then you’ll love " +
                                "the early withdrawal option. These properties give the speculator " +
                                "more control over the bets already placed and could ultimately " +
                                "make a big difference in the overall bankroll if you wager your " +
                                "cards correctly. The early payout is often referred to as the " +
                                "cashout by most sports betting sites."
                ),
                new Strategy(
                        "Bet live on over 1.5 goals",
                        "Live betting on “over 1.5 goals” is a very lucrative betting " +
                                "strategy. This bet has an interesting advantage due to the " +
                                "development of the odds. First of all, you should do the same " +
                                "thing as with normal over / under bets. Find a game where you " +
                                "expect an over 2.5. Only use this betting strategy for bets " +
                                "where you expect this."
                ),
                new Strategy(
                        "What’s a Money Race?",
                        "A money race is a betting strategy in which the profit amount " +
                                "from a winning bet is invested directly in the next bet. " +
                                "This is usually continued through numerous bets until a desired " +
                                "amount of money is reached."
                ),
                new Strategy(
                        "Betting on a draw",
                        "A tie is not the most popular bet out there. If only, " +
                                "because it is much more fun to celebrate a team’s victory. " +
                                "But: draws pay well! Sometimes it makes sense to go for a draw " +
                                "instead of traditional win or loss. And every game starts " +
                                "with a draw …"
                )
        );
    }

    public static List<Strategy> getFavorites(Context context) {
        List<Strategy> strategies = new ArrayList<>();

        SharedPreferences preferences =
                context.getSharedPreferences("com.leonino.bettingstrategies", Context.MODE_PRIVATE);

        for(String fav : preferences.getStringSet("favorites", new HashSet<>())) {
            for(Strategy strategy : getStrategies()) {
                if(fav.equals(strategy.getName())) {
                    strategy.setFavorite(true);
                    strategies.add(strategy);
                }
            }
        }

        return strategies;
    }

    public static String getFullDescription(String name) {
        switch (name) {
            case "1X on home outsiders strategy":
                return "A betting strategy that has been successful in the past is the bet on the " +
                        "“double chance” 1X if an outsider plays against a favorite at home. In " +
                        "this case, the “1X” bet brings respectable odds and very interesting " +
                        "profit opportunities. \n\n" +
                        "You don’t even have to choose and analyze games that contain absolute" +
                        " extremes and obvious class differences with this strategy. So, you don’t " +
                        "necessarily have to bet against Barcelona, Bayern or Juventus as an away " +
                        "team. Here, we would probably move away from the value bets. Even if we " +
                        "opt for teams that are not big outsiders, but are still outsiders " +
                        "according to the odds, we find highly interesting odds between " +
                        "1.60 and 2.50. \n\n" +
                        "As with all bets, it is important to analyze in advance and not blindly " +
                        "going for any team. You should of course take statistics into account, " +
                        "advance information about injuries and suspensions, as well as the current " +
                        "shape of the teams. The home advantage of the outsider, for whom games in" +
                        " front of their own audience against a “bigger one” also represent a " +
                        "special motivation, should not be underestimated as it brings another " +
                        "small advantage for the home team. Especially when the respective " +
                        "favorite has recently shown itself shaky against “smaller ones”, you " +
                        "can definitely find value in such an outsider bet with double chances.";
            case "All-in on odds at 1.20 strategy":
                return "This betting strategy involves winning numerous bets one after" +
                        " the other and always using the maximum offers the opportunity to" +
                        " earn decent money. But it is also clear that all the money is " +
                        "gone if you lose a bet. But if you manage to win 30, 35, maybe " +
                        "even 40 times in a row, you’ll get big money! \n\n" +
                        "We use odds around 1.20 for this – ideally you should look for the bets you are playing live. As with the strategy of betting over 1.5 goals in what is estimated to be typical “over” games, you can wait here until the odds have reached the desired level. The over 0.5 bet is ideal here – i.e. the bet that the game will not end 0-0. Usually, after goalless 30 minutes, you get a rate of 1.20 – depending on the match, this can of course be lower, but sometimes even higher. Of course, it is a matter of taste with which type of bet you want to monetize your betting sequence, or money race‘ as it is also called. \n\n" +
                        "It is important that you always play roughly the same odds. This is certainly a test of patience and not particularly spectacular at first, but there is no exact goal and you can stop at any time and have your winnings paid out. For example, if you start such a series of bets with a stake of 10 €, that’s all you can lose. So you now find a bet with odds 1.20, win it and immediately play the 12 € you won again on odds that are around this amount. You win 14.40 € – which will be invested in the next bet. \n\n" +
                        "The profits will only become noticeable very slowly, but will increase sharply over time, because of course the stake grows higher and higher. If you actually manage to get 30 picks right in a row, your 10 € from the beginning will already be a whopping 2,373.76 €. After 35 correct pick we would already be at 5,906.68 € and after 40 correct picks at 14,697.71 €. \n\n" +
                        "Of course, it is far from likely to have so many tips in a row right – but this progressive betting strategy is also something for the thrill. If you do not start the betting sequence with too high a stake, you cannot lose much and there is of course the possibility of starting a real streak when employing this betting strategy.";
            case "The Fibonacci betting system":
                return "The Fibonacci betting system is one of many betting strategies available today. Here we explain what it is all about.\n\n" +
                        "Fibonacci sequence betting is undoubtedly a controversial concept. But there are definitely sports bettors who were able to achieve great success with it. This strategy carries some risks, but with the necessary luck and the right nose, you can be successful while employing this strategy.\n\n" +
                        "The basic concept of betting according to the Fibonacci sequence is simple: bet on a tie. If you lose, just bet on the next tie according to a certain key and start increasing your stake.\n\n" +
                        "It is important that the odds for the tie are above 2.62 (more precisely: 2.618); luckily for those who want to employ this strategy, there are many tie bets for this minimum odds. The higher the rate, the better.\n\n" +
                        "If you lose, you simply bet the next tie after a Fibonacci sequence. It is a sequence of numbers in which the sum of two consecutive numbers results in the next number, making the Fibonacci sequence an infinite sequence of natural numbers.\n\n" +
                        "So if you start betting with 1 € on the first draw with odds> 2.62 and lose, then the next time you bet 1 € again, then 2 €, then 3 €, then 5 €, then 8 €, then 13 € and so on.\n\n" +
                        "It is mathematically understandable that every profit that you will achieve with this bet will offset the previous losses and you will even make a net profit.\n\n\n" +
                        "An example of the Fibonacci bet\n\n" +
                        "Let’s take the example of the situation where you lose ten times in a row and win your bet the eleventh time. In this case, you have already gambled away 143 € and finally successfully placed the eleventh number in the Fibonacci sequence, 144, on a bet. If we now assume that the successful bet had odds of @ 2.80, you win 403.20 €. You have wagered a total of 287 €, making your net profit 116.20 €.\n\n" +
                        "The disadvantage of this strategy is also obvious. Assuming you lose not ten bets in a row, but twenty, then you would have already lost 16,910 € in stakes. This is a huge bankroll, which you should of course never risk for such a betting sequence. You can find more about this in our explanations on bankroll management.";
            case "The Kelly formula":
                return "There are of course numerous ideas, concepts and formulas that can help you calculate the ideal stake on a bet. One of them is the Kelly formula.\n\n" +
                        "Of course, this is no guarantee that you will always bet correctly and the assessment of how likely the outcome of a game is, does still remain up to you. But the Kelly formula can help you choose the size of your bet.\n\n\n" +
                        "This is how the Kelly formula works\n\n" +
                        "•You choose a game or an event and rate the outcome as a percentage\n" +
                        "•Example: Austria defeats Germany – you rate this outcome with a probability of 20%\n" +
                        "•Now, you are looking for an odd for this event that seems fair to you\n" +
                        "•Then, you put the probability and the odds in the Kelly formula and get a value from it\n\n" +
                        "The Kelly Formula hereby recommends that, given the probability that you have determined yourself and the odds you have chosen, you should bet 2.22% of your bankroll on this event.\n\n" +
                        "Now, of course, the use of this formula also depends heavily on your assessment of the probability. And if you consider a game outcome to be very likely and thus increase the value considerably, then it can happen that you get 30% or even more of your bankroll as a result. Of course, caution is advised here because your bankroll can slide down very quickly this way.";
            case "Early cashout in sports betting":
                return "Have you ever regretted placing a particular bet and wished that you could somehow withdraw it? Or maybe you had doubts as to whether the team you supported could really hold the lead? If your answer to any of the questions is yes, then you’ll love the early withdrawal option. These properties give the speculator more control over the bets already placed and could ultimately make a big difference in the overall bankroll if you wager your cards correctly. The early payout is often referred to as the cashout by most sports betting sites.\n\n" +
                        "What is the early withdrawal option?\n\n" +
                        "The early withdrawal option allows sports bettors to withdraw their bets early, before they have been settled. So, you can either make a profit or get a part of your stake back, depending on your selection at that time. The feature is available as soon as you have placed your pre-match or in-play bet and the payout amount will fluctuate based on the events taking place in the game.\n\n" +
                        "The cashout feature is available for individual bets and accumulator bets, but note that it does not apply to all bet types, such as the outcome (1×2) and some other popular markets. Speculators can take advantage of the exciting option when placing their bets in soccer, tennis, basketball, cricket, baseball and even horse racing – on both desktop and mobile.\n\n\n" +
                        "When to make an early cashout\n\n" +
                        "If the team or player you are supporting is in a winning position but is being led out by the opponent, then you should definitely make a cashout and secure the appropriate profit instead of watching your potential profit and stake vanish into thin air. Your forecast proves correct and your choices lose the lead.\n\n" +
                        "Alternatively, the option of paying out can also be used to limit losses, which can be a very good strategy in the long term. If your selection doesn’t win at the moment, and it doesn’t seem like things are going to turn, it is wise to withdraw early on, so that you can be sure that you get some of your deposit back. This may not seem like a popular strategy, but it can definitely help speculators stay afloat for longer periods of time.";
            case "Bet live on over 1.5 goals":
                return "With this betting strategy, you are betting on live games on the bet type “Over 1.5 goals”.\n\n" +
                        "Live betting on “over 1.5 goals” is a very lucrative betting strategy. This bet has an interesting advantage due to the development of the odds. First of all, you should do the same thing as with normal over / under bets. Find a game where you expect an over 2.5. Only use this betting strategy for bets where you expect this.\n\n" +
                        "Before the game, the odds of an over 1.5 will be very low. In some cases, it is no higher than 1.20. But while the game is running and the goals are missing, this rate increases almost every minute and becomes more and more lucrative. Now you have to be patient. Ideally – as with any bet – you should watch the game live at the same time in order to have the greatest possible advantage.\n\n" +
                        "Now wait until the bet has odds between 1.50 and 2.00. The higher the better, but of course the timing is important. If a goal is scored, the bet is over before it has even started and you have to find a new game. This strategy only works if it is 0-0 long enough. Usually, you will have to wait until the 35th to 55th minute so that the odds on the over 1.5 are fair. However, we recommend that you still bet in the first half – it is important that the odds are 1.50 or higher.\n\n" +
                        "You analyzed the game before kick-off and expected an over 2.5. If you’re not completely wrong, goals will still be scored here. And we are eagerly awaiting the first goal as soon as the bet is played.\n\n" +
                        "If a goal is scored quite early after your bet, then you have – at least with most bookmakers who allow this – a profitable exit strategy: The odds for the over 1.5 will of course rattle off after the first goal. Now you can have the bet paid out via cashout, you can virtually “sell” it. You will definitely get out with a plus.\n\n" +
                        "The riskier option is to wait for the second goal and win the bet anyway. Here it is of course advisable to watch the game live. If there is a goal in the air, you can still wait and let the bet stand. If the game is a tense affair, then it may be better to sell the bet.\n\n" +
                        "In any case, for such a strategy it is advisable to bet with a betting company that allows a live cashout option. For more information on the subject of live betting, see also the live betting section of our page.";
            case "What’s a Money Race?":
                return "A money race is a betting strategy in which the profit amount from a winning bet is invested directly in the next bet. This is usually continued through numerous bets until a desired amount of money is reached.\n\n" +
                        "The Money Race can be run with all possible types of bets. In most cases, however, the focus is specifically on low odds and thus “safe bets”, in order to win as many bets as possible in a row. In this case, the Money Race is particularly interesting for sports bettors with a high bankroll. If the Money Race is started with a rather high initial stake, you will save yourself numerous necessary profits on the way to the self-imposed goal. At the same time, however, the risk of loss is also greater.\n\n" +
                        "If you decide to start a Money Race with 20 € and always bet on events with odds 1.20, you need 22 consecutive wins to get over 1,000 €. However, if you start with a stake of 100 €, after 13 bets you have won with odds of 1.20, you will exceed the 1,000 € mark. This is shown in this calculation example:\n" +
                        "20 € x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 = 1,104.12 €\n\n" +
                        "100 € x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 x 1.2 = 1,069.93 €\n\n" +
                        "With the help of higher odds, a Money Race can of course also be accelerated, but the risk of losing all winnings is significantly higher. Usually you vary your bet a bit; after all, it is also very important with the Money Race to avoid going wild, but to research well instead despite the low odds. As with all bets, it is important to bet when you are certain that the outcome is highly probable. Even if you are strongly focused on an average odd, in our example the rate 1.20, it is not a problem if there is a 1.40 or 1.50 in between. Here, too, research and conviction is of outmost importance.";
            case "Betting on a draw":
                return "A tie is not the most popular bet out there. If only, because it is much more fun to celebrate a team’s victory.\n" +
                        "But: draws pay well! Sometimes it makes sense to go for a draw instead of traditional win or loss. And every game starts with a draw …\n\n" +
                        "Try to find games where both teams will have a hard time defeating each other. For example, look for teams from the better league average that compete against top teams at home. The visiting team has the quality to not lose, while at the same time they will have problems when it comes to actually bending the favourite. In this situation, both teams are happy with a draw and that is often the result.\n\n" +
                        "Another quick and easy way to identify potential ties is to check the Asian handicap odds.\n" +
                        "Look for games in which the handicap was set to zero (0) or a draw. This means that both teams have been rated more or less equally, and the bookmakers do not want to give either team a head start. Games like these tend to end in a draw more often than you might think.";
            default:
                return "";
        }
    }
}
