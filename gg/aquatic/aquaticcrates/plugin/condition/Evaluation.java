package gg.aquatic.aquaticcrates.plugin.condition;

import gg.aquatic.waves.libs.kotlin.Metadata;
import gg.aquatic.waves.libs.kotlin.collections.CollectionsKt;
import gg.aquatic.waves.libs.kotlin.jvm.internal.Intrinsics;
import gg.aquatic.waves.libs.kotlin.jvm.internal.SourceDebugExtension;
import gg.aquatic.waves.libs.kotlin.text.MatchResult;
import gg.aquatic.waves.libs.kotlin.text.Regex;
import gg.aquatic.waves.libs.kotlin.text.StringsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007¨\u0006\u0011"},
   d2 = {"Lgg/aquatic/aquaticcrates/plugin/condition/Evaluation;", "", "<init>", "()V", "evaluateLogicalCondition", "", "condition", "", "evaluateSimpleCondition", "evaluateMathOperations", "expression", "compareNumbers", "left", "", "right", "operator", "compareStrings", "plugin"}
)
@SourceDebugExtension({"SMAP\nEvaluation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Evaluation.kt\ngg/aquatic/aquaticcrates/plugin/condition/Evaluation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1563#2:98\n1634#2,3:99\n1761#2,2:102\n1563#2:104\n1634#2,3:105\n1740#2,3:108\n1763#2:111\n*S KotlinDebug\n*F\n+ 1 Evaluation.kt\ngg/aquatic/aquaticcrates/plugin/condition/Evaluation\n*L\n8#1:98\n8#1:99,3\n10#1:102,2\n12#1:104\n12#1:105,3\n13#1:108,3\n10#1:111\n*E\n"})
public final class Evaluation {
   @NotNull
   public static final Evaluation INSTANCE = new Evaluation();

   private Evaluation() {
   }

   public final boolean evaluateLogicalCondition(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "condition");
      CharSequence var10000 = (CharSequence)var1;
      String[] var3 = new String[]{"||"};
      Iterable var21 = (Iterable)StringsKt.split$default(var10000, var3, false, 0, 6, (Object)null);
      boolean var4 = false;
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var21, 10)));
      boolean var7 = false;
      Iterator var8 = var21.iterator();

      while(var8.hasNext()) {
         Object var9 = var8.next();
         String var10 = (String)var9;
         boolean var11 = false;
         var6.add(StringsKt.trim((CharSequence)var10).toString());
      }

      List var2 = (List)var6;
      var21 = (Iterable)var2;
      var4 = false;
      boolean var32;
      if (var21 instanceof Collection && ((Collection)var21).isEmpty()) {
         var32 = false;
      } else {
         Iterator var5 = var21.iterator();

         while(true) {
            if (!var5.hasNext()) {
               var32 = false;
               break;
            }

            Object var22 = var5.next();
            String var23 = (String)var22;
            boolean var24 = false;
            var10000 = (CharSequence)var23;
            String[] var25 = new String[]{"&&"};
            Iterable var26 = (Iterable)StringsKt.split$default(var10000, var25, false, 0, 6, (Object)null);
            boolean var27 = false;
            Collection var12 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var26, 10)));
            boolean var13 = false;
            Iterator var14 = var26.iterator();

            while(var14.hasNext()) {
               Object var15 = var14.next();
               String var16 = (String)var15;
               boolean var18 = false;
               var12.add(StringsKt.trim((CharSequence)var16).toString());
            }

            List var19 = (List)var12;
            var26 = (Iterable)var19;
            var27 = false;
            if (var26 instanceof Collection && ((Collection)var26).isEmpty()) {
               var32 = true;
            } else {
               Iterator var28 = var26.iterator();

               while(true) {
                  if (!var28.hasNext()) {
                     var32 = true;
                     break;
                  }

                  Object var29 = var28.next();
                  String var30 = (String)var29;
                  boolean var31 = false;
                  if (!INSTANCE.evaluateSimpleCondition(var30)) {
                     var32 = false;
                     break;
                  }
               }
            }

            if (var32) {
               var32 = true;
               break;
            }
         }
      }

      return var32;
   }

   public final boolean evaluateSimpleCondition(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "condition");
      String var2 = this.evaluateMathOperations(var1);
      Regex var3 = new Regex("(.*)\\s*(==|!=|<|>|<=|>=)\\s*(.*)");
      MatchResult var10000 = Regex.find$default(var3, (CharSequence)var2, 0, 2, (Object)null);
      if (var10000 == null) {
         return false;
      } else {
         MatchResult var4 = var10000;
         String var5 = StringsKt.trim((CharSequence)((String)var4.getGroupValues().get(1))).toString();
         String var6 = StringsKt.trim((CharSequence)((String)var4.getGroupValues().get(2))).toString();
         String var7 = StringsKt.trim((CharSequence)((String)var4.getGroupValues().get(3))).toString();
         return StringsKt.toDoubleOrNull(var5) != null && StringsKt.toDoubleOrNull(var7) != null ? this.compareNumbers(Double.parseDouble(var5), Double.parseDouble(var7), var6) : this.compareStrings(var5, var7, var6);
      }
   }

   @NotNull
   public final String evaluateMathOperations(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "expression");
      CharSequence var3 = (CharSequence)var1;
      Regex var4 = new Regex("\\s+");
      String var5 = "";
      String var2 = var4.replace(var3, var5);
      Regex var13 = new Regex("(\\d+\\.?\\d*)\\s*([%+\\-*/])\\s*(\\d+\\.?\\d*)");

      while(true) {
         if (var13.containsMatchIn((CharSequence)var2)) {
            MatchResult var10000 = Regex.find$default(var13, (CharSequence)var2, 0, 2, (Object)null);
            if (var10000 != null) {
               MatchResult var14 = var10000;
               double var15 = Double.parseDouble((String)var14.getGroupValues().get(1));
               String var7 = (String)var14.getGroupValues().get(2);
               double var8 = Double.parseDouble((String)var14.getGroupValues().get(3));
               double var16;
               switch(var7.hashCode()) {
               case 37:
                  if (!var7.equals("%")) {
                     throw new IllegalArgumentException("Unsupported operator: " + var7);
                  }

                  var16 = var15 % var8;
                  break;
               case 42:
                  if (!var7.equals("*")) {
                     throw new IllegalArgumentException("Unsupported operator: " + var7);
                  }

                  var16 = var15 * var8;
                  break;
               case 43:
                  if (!var7.equals("+")) {
                     throw new IllegalArgumentException("Unsupported operator: " + var7);
                  }

                  var16 = var15 + var8;
                  break;
               case 45:
                  if (!var7.equals("-")) {
                     throw new IllegalArgumentException("Unsupported operator: " + var7);
                  }

                  var16 = var15 - var8;
                  break;
               case 47:
                  if (var7.equals("/")) {
                     if (var8 == 0.0D) {
                        throw new IllegalArgumentException("Division by zero.");
                     }

                     var16 = var15 / var8;
                     break;
                  }

                  throw new IllegalArgumentException("Unsupported operator: " + var7);
               default:
                  throw new IllegalArgumentException("Unsupported operator: " + var7);
               }

               double var10 = var16;
               var2 = StringsKt.replace$default(var2, var14.getValue(), String.valueOf(var10), false, 4, (Object)null);
               continue;
            }
         }

         return var2;
      }
   }

   public final boolean compareNumbers(double var1, double var3, @NotNull String var5) {
      Intrinsics.checkNotNullParameter(var5, "operator");
      boolean var10000;
      switch(var5.hashCode()) {
      case 60:
         if (var5.equals("<")) {
            var10000 = var1 < var3;
            return var10000;
         }
         break;
      case 62:
         if (var5.equals(">")) {
            var10000 = var1 > var3;
            return var10000;
         }
         break;
      case 1084:
         if (var5.equals("!=")) {
            var10000 = var1 != var3;
            return var10000;
         }
         break;
      case 1921:
         if (var5.equals("<=")) {
            var10000 = var1 <= var3;
            return var10000;
         }
         break;
      case 1952:
         if (var5.equals("==")) {
            var10000 = var1 == var3;
            return var10000;
         }
         break;
      case 1983:
         if (var5.equals(">=")) {
            var10000 = var1 >= var3;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   public final boolean compareStrings(@NotNull String var1, @NotNull String var2, @NotNull String var3) {
      Intrinsics.checkNotNullParameter(var1, "left");
      Intrinsics.checkNotNullParameter(var2, "right");
      Intrinsics.checkNotNullParameter(var3, "operator");
      return Intrinsics.areEqual(var3, "==") ? Intrinsics.areEqual(var1, var2) : (Intrinsics.areEqual(var3, "!=") ? !Intrinsics.areEqual(var1, var2) : false);
   }
}
