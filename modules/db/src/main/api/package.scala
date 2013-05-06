package lila.db

import reactivemongo.core.commands.LastError

package object api extends api.$operator {

  private[api] def successful(result: Fu[LastError]): Funit = 
    result flatMap { lastErr ⇒
      lastErr.ok.fold(funit, fuck(lastErr.stringify))
    }

}
